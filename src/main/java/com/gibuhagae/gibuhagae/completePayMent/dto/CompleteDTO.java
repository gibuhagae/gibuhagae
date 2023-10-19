package com.gibuhagae.gibuhagae.completePayMent.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;



@Setter
@Getter
@ToString
public class CompleteDTO {

    private int paymentNo;
    private int memberNo;
    private String paymentDate;
    private int totalOrderPrice;
    private int paymentPrice;
    private int orderNo;
    private int itemCode;
    private int optionCode;
    private int count;
    private int price;
    private int orderDetailCode;
    private String paymentStatus;
    private String itemName;
    private String optionName;
    private String imgSrc;
}
