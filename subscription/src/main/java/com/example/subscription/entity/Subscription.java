package com.example.subscription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

@Entity
@Data
@Table(name = "subscription")
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long subscriptionId;
    private String msisdn;
    private Long idCampaing;
    private Long offerId;
    private String offerName;
    private Long carrierId;
    private String countryIso;
    private Boolean active;
    private String state;
    private Date subscriptionDate;
    private Timestamp subscriptionTimestamp;
    private Timestamp unsubscriptionTimestamp;
    private Date firstCharged;
    private Integer billing;
    private Date dateBilling;

    public Subscription(HashMap<String, ?> datos) {
        this.subscriptionId = (Long) datos.get("subscriptionId");
        this.msisdn = (String) datos.get("msisdn");
        this.idCampaing = (Long) datos.get("idCampaing");
        this.offerId = (Long) datos.get("offerId");
        this.offerName = (String) datos.get("offerName");
        this.active = true;
        this.state = (String) datos.get("state");
        this.subscriptionDate = Date.valueOf(LocalDate.now());
        this.subscriptionTimestamp = Timestamp.valueOf(LocalDateTime.now());
        this.unsubscriptionTimestamp = null;
        this.billing = (Integer) datos.get("charged");
        this.dateBilling = Date.valueOf(LocalDate.now());

        if (dateBilling.equals(subscriptionDate)) {
            this.firstCharged = Date.valueOf(LocalDate.now());
        } else {
            this.firstCharged = null;
        }
    }
}
