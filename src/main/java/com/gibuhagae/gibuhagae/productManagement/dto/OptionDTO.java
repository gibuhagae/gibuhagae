package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
public class OptionDTO {

    private int optionCode;
    private String optionName;
    private Date registDate;
    private int salePrice;
    private int itemCode;
    private int count;
}
