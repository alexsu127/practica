package com.example.subscription.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long subscriptionId;
    private Integer idCampaing;
    private String state;
    private Long offerId;
    private String offerName;
    private Date subscriptionStartDate;
    private Date subscriptionEndDate;
    private Date renewalDate;
    private Timestamp timestamp;
    private Integer charged;
    private String msisdn;
}
