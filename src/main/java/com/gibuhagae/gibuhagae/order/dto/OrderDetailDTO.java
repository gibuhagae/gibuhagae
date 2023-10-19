package com.gibuhagae.gibuhagae.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailDTO {
    private int orderDetailCode;
    private int itemCode;
    private int optionCode;
    private int orderNo;
    private int count;
    private int price;
}
