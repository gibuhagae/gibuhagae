package com.gibuhagae.gibuhagae.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class PostDTO {
    private Long orderNo;
    private String recipientName;
    private String recipientPhone;
    private String zipCode;
    private String address;
    private String registrationDate;
    private String deliveryRequest;
    private String registrationNo;
    private String postOffice;

}
