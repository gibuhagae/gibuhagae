package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductManagementDTO {
    private int itemCode;
    private String itemName;
    private String saleStatus;
    private Date registDate;
}
