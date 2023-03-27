package com.example.landing.repository;

import com.example.landing.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    Optional<Subscription> findByMsisdnAndTariff(String msisdn, String tariff);
}
