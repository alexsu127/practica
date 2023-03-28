package com.example.subscription.controller;

import com.example.subscription.service.SubscriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String msisdn,
            @RequestParam String offer_name
    ) {
        return subscriptionService.login(msisdn, offer_name) ? ResponseEntity.ok("200") : ResponseEntity.status(HttpStatus.FORBIDDEN).body("403");
    }

    @PostMapping("/unsubscribe")
    public String unsubscribe(
            @RequestParam String prueba
    ) {
        return prueba;
    }
}
