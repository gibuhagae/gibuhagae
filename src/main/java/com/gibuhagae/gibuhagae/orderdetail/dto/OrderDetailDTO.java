package com.gibuhagae.gibuhagae.orderdetail.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class OrderDetailDTO {
    private Long orderDetailCode;
    private Long itemCode;
    private Long optionCode;
    private Long OrderNo;
    private int  count;
    private int  price;
}
