package com.example.subscription.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "first_step")
public class FirstStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer idCampaing;

    private String countryIso;

    private String fecha;

    private String hora;

    private String msisdn;

    private Integer carrier;

    private String tariff;

    private Integer pin;

}
