package com.example.notification.service;

import com.example.notification.dto.NotificationDTO;
import com.example.notification.entity.Notification;
import com.example.notification.repository.NotificationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    public String handleNotification(String json) {
        try {
            NotificationDTO notificationDto = objectMapper.readValue(json, NotificationDTO.class);

            Notification notification = new Notification(notificationDto);
            log.info("(AFG) Saving notification to DB: {}", notificationDto);

            notificationRepository.save(notification);

            rabbitTemplate.convertAndSend("notification", json);

            return "Ok";
        } catch (Exception e) {
            log.error("(AFG) Error parsing Notification {} cause by {}", json, e.getMessage());
            return "Error";
        }
    }
}
