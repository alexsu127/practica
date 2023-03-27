package com.example.landing.repository;

import com.example.landing.entity.FirstStep;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FirstStepRepository extends CrudRepository<FirstStep, Long> {}
