package com.gibuhagae.gibuhagae.orderDetail.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDTO {

    private int orderDetailCode;
    private int orderNo;
    private int itemCode;
    private int optionCode;
    private int count;
    private int price;
    private String itemName;
    private String optionName;
    private String imgSrc;
}
