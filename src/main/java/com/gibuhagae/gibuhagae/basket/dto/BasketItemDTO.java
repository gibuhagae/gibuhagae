package com.gibuhagae.gibuhagae.basket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BasketItemDTO {

    private int itemCode;
    private int optionCode;
    private int count;
    private String itemName;
    private String optionName;
    private int price;
    private String filePath;
}
