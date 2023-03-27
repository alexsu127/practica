package com.example.subscription.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;

@Entity
@Data
@Table(name = "subscription")
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
        this.active = active;
        this.state = (String) datos.get("state");
        this.subscriptionDate = subscriptionDate;
        this.subscriptionTimestamp = subscriptionTimestamp;
        this.unsubscriptionTimestamp = unsubscriptionTimestamp;
        this.firstCharged = firstCharged;
        this.billing += (Integer) datos.get("charged");
        this.dateBilling = dateBilling;
    }
}