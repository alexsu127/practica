package com.example.subscription.service;

import com.example.subscription.entity.FirstStep;
import com.example.subscription.entity.Subscription;
import com.example.subscription.repository.FirstStepRepository;
import com.example.subscription.repository.SubscriptionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
            Optional<FirstStep> firstStep = firstStepRepository.findByMsisdnAndTariffOrderByHoraDesc(
                    (String) result.get("msisdn"),
                    getTariff((String) result.get("offer_name"))
            );
            Subscription subscription = new Subscription(result);

            if (firstStep.isPresent()) {
                subscription.setCarrierId(Long.valueOf(firstStep.get().getCarrier()));
                subscription.setCountryIso(firstStep.get().getCountryIso());
            }

            Optional<Subscription> repetido = subscriptionRepository.findByMsisdnAndOfferName(
                    (String) result.get("msisdn"),
                    (String) result.get("offer_name")
            );

            if (repetido.isPresent()) {
                if (subscription.getState().equals("active")) {
                    repetido.get().setActive(true);
                    repetido.get().setUnsubscriptionTimestamp(null);
                } else {
                    repetido.get().setActive(false);
                    repetido.get().setUnsubscriptionTimestamp(Timestamp.valueOf(LocalDateTime.now()));
                }
                if (repetido.get().getFirstCharged() != null) {
                    repetido.get().setFirstCharged(null);
                }

                repetido.get().setState(subscription.getState());
                repetido.get().setBilling(repetido.get().getBilling() + subscription.getBilling());

                subscriptionRepository.save(repetido.get());
                return "Actualizada la subscripción con nº " + repetido.get().getMsisdn();
            }

            subscriptionRepository.save(subscription);

            return "Insertado " + subscription;
        } catch (Exception e) {
            return "Error al recibir los datos";
        }
    }

    public boolean login(String msisdn, String offerName) {
        Optional<Subscription> subscription = subscriptionRepository.findByMsisdnAndOfferName(msisdn, offerName);
        return subscription.isPresent();
    }

    private String getTariff(String offerName) {
        return offerName.split(" ")[1];
    }
}