package com.example.subscription.service;

import com.example.subscription.entity.FirstStep;
import com.example.subscription.entity.Subscription;
import com.example.subscription.repository.FirstStepRepository;
import com.example.subscription.repository.SubscriptionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private FirstStepRepository firstStepRepository;

    public String newSubscription(String json) {
        try {
            HashMap<String, ?> result = new ObjectMapper().readValue(json, HashMap.class);
            Optional<FirstStep> firstStep = firstStepRepository.findByMsisdnAndTariffOrderByHoraDesc((String) result.get("msisdn"), getTariff((String) result.get("offerName")));
            Subscription subscription = new Subscription(result);

            if (firstStep.isPresent()) {
                subscription.setCarrierId(Long.valueOf(firstStep.get().getCarrier()));
                subscription.setCountryIso(firstStep.get().getCountryIso());

                return firstStep.toString();
            }

            return "puto el que lo lea 2.0";
        } catch (Exception e) {
            return "puto el que lo lea";
        }
    }

    private String getTariff(String offerName) {
        return offerName.split(" ")[1];
    }
}