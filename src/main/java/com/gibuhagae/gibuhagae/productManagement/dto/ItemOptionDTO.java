package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter @ToString
public class ItemOptionDTO {
    private Long optionCode;
    private String optionName;
    private Date registDate;
    private int salePrice;
    private Long itemCode;
    private int count;
}
