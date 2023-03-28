package com.example.notification.controller;

import com.example.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping("/af")
    public ResponseEntity<String> notificationReciever(@RequestBody String json) {
        log.info("Notification recieved (AFG): {}", json);

        String response = notificationService.handleNotification(json);

        if (response.equalsIgnoreCase("OK")) {
            return ResponseEntity.ok("200");
        } else {
            ResponseEntity<String> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ERROR");
            log.info("responseEntity (AFG): {}", responseEntity);
            return responseEntity;
        }
    }
}
