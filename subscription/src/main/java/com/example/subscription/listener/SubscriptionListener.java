package com.example.subscription.listener;

import com.example.subscription.service.SubscriptionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
@RabbitListener(queues = "notification")
@AllArgsConstructor
public class SubscriptionListener {
    private final SubscriptionService subscriptionService;

    @Bean
    public Queue notification() {
        final Map<String, Object> p = new HashMap<>();
        p.put("x-max-priority", 10);
        return new Queue("notification", true, false, false, p);
    }

    @RabbitHandler
    public void onMessage(@Payload final String element) {
        log.info("Info : {}", element);
        log.info("Mensaje : {}", subscriptionService.newSubscription(element));
    }
}
