package com.example.subscription.repository;

import com.example.subscription.entity.FirstStep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FirstStepRepository extends CrudRepository<FirstStep, Long> {
    Optional<FirstStep> findByMsisdnAndTariffOrderByHoraDesc(String msisdn, String tariff);
}
