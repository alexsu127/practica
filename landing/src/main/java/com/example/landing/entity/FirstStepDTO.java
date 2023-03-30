package com.example.landing.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FirstStepDTO {
    private int id;
    private int subscription_id;
    private int id_campaing;
    private String state;
    private int offer_id;
    private String offer_name;
    private int charged;
    private String msisdn;
}
