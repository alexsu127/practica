package com.example.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class NotificationDTO {
    private Long id;
    private Long subscriptionId;
    private Integer idCampaing;
    private String state;
    private Long offerId;
    private String offerName;
    private Integer charged;
    private String msisdn;
}
