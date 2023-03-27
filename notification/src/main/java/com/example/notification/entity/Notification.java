package com.example.notification.entity;

import com.example.notification.dto.NotificationDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public Notification(NotificationDTO notificationDto) {
        this.subscriptionId = notificationDto.getSubscriptionId();
        this.idCampaing = notificationDto.getIdCampaing();
        this.state = notificationDto.getState();
        this.offerId = notificationDto.getOfferId();
        this.offerName = notificationDto.getOfferName();
        this.subscriptionStartDate = Date.valueOf(LocalDate.now());
        this.subscriptionEndDate = null;
        this.charged = notificationDto.getCharged();
        if (charged != 0) {
            this.renewalDate = Date.valueOf(LocalDate.now());
        } else {
            this.renewalDate = null;
        }
        this.timestamp = Timestamp.valueOf(LocalDateTime.now());
        this.msisdn = notificationDto.getMsisdn();
    }
}
