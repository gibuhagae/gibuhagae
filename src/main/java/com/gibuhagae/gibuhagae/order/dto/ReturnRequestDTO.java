package com.gibuhagae.gibuhagae.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class ReturnRequestDTO {
    private Date orderDate;
    private Date cancelDate;
    private int orderCount;
    private String paymentPrice;
    private Long orderNo;
    private Long refundNumber;
    private String recipientName;
    private String recipientPhone;
    private String itemName;
    private String optionName;
    private String zipCode;
    private String address;
    private String addressDetail;
    private int registrationNo;
    private String postOffice;
    private String refundReason;
    private String userId;

}
