package com.gibuhagae.gibuhagae.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OptionDTO {

    private Long optionCode;
    private String optionName;
    private Date registDate;
    private Long salePrice;
    private Long itemCode;
    private Long count;
}
