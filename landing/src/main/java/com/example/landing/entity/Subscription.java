package com.example.landing.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subscription")
public class Subscription {
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

    private Integer active;
}
