package com.example.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class NotificationDTO {
    private Long id;
    private Long subscription_id;
    private Integer id_campaing;
    private String state;
    private Long offer_id;
    private String offer_name;
    private Integer charged;
    private String msisdn;
}
