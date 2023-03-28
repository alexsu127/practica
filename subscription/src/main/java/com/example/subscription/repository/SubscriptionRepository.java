package com.example.subscription.repository;

import com.example.subscription.entity.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    Optional<Subscription> findByMsisdnAndOfferName(String msisdn, String offerName);
}
