package com.gibuhagae.gibuhagae.payment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class PaymentDTO {

    private Long paymentNo;
    private String name;
    private Date paymentDate;
    private String zipcode;
    private String addr1;
    private String addr2;
    private String shippingMessage;
    private int phoneValue;
    private int phone1;
    private int phone2;
    private String email1;
    private String domain;
    private List<Integer> count;
    private int shippingPrice;
    private int itemTotalPrice;
    private int totalPrice;
    private int rewardAmount;
    private String checkReward;
    private List<Integer> itemCode;
    private List<Integer> optionCode;
    private List<Integer> itemPrice;
//    private int orderNo;
    private int orderCount;
//    private int count;
//    private int itemCode;
//    private int optionCode;
//    private int itemPrice;
}
