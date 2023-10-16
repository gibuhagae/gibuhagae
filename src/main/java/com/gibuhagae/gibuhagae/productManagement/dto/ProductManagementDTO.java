package com.gibuhagae.gibuhagae.productManagement.dto;

import com.gibuhagae.gibuhagae.productDetail.dto.ProductDetailDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductManagementDTO {
    private int itemCode;
    private String itemName;
    private String saleStatus;
    private Date registDate;
}
