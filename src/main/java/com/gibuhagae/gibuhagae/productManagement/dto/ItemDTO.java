package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter @Getter @ToString
public class ItemDTO {
    private Long itemCode;
    private String itemName;
    private String saleStatus;
    private Date registDate;
    private int categoryCode;
    private int totalCount;
}
