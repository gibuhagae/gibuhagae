package com.gibuhagae.gibuhagae.basket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BasketItemDTO {

    private String itemImg;
    private String itemName;
    private int itemCode;
    private int optionCode;
    private String optionName;
    private int itemQty;
    private int price;
}
