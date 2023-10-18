package com.gibuhagae.gibuhagae.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Setter @Getter @ToString
public class SwapRequestDTO {
    private Long orderNo;
    private Date orderDate;
    private int orderCount;
    private String paymentPrice;
    private Long swapNumber;
    private String swapReason;
    private String recipientName;
    private String recipientPhone;
    private String itemName;
    private String optionName;
    private String zipCode;
    private String address;
    private String addressDetail;
    private int registrationNo;
    private String postOffice;
    private String userId;

}
