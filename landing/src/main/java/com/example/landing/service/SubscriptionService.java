package com.example.landing.service;

import com.example.landing.entity.FirstStep;
import com.example.landing.entity.Subscription;
import com.example.landing.repository.FirstStepRepository;
import com.example.landing.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Optional;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private FirstStepRepository firstStepRepository;

    public void newSubscription(int id) {
        Optional<FirstStep> firstStep = firstStepRepository.findById((long) id);
        if (firstStep.isPresent()) {
            Subscription subscription = new Subscription();
            subscription.setIdCampaing(firstStep.get().getIdCampaing());
            subscription.setCountryIso(firstStep.get().getCountryIso());
            subscription.setFecha(new Date(System.currentTimeMillis()).toString());
            subscription.setHora(new Timestamp(System.currentTimeMillis()).toString());
            subscription.setMsisdn(firstStep.get().getMsisdn());
            subscription.setCarrier(firstStep.get().getCarrier());
            subscription.setTariff(firstStep.get().getTariff());
            subscription.setPin(firstStep.get().getPin());
            subscription.setActive(1);

            subscriptionRepository.save(subscription);
        }
    }
}