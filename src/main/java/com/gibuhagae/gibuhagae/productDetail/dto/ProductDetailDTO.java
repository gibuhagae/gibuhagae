package com.gibuhagae.gibuhagae.productDetail.dto;

import com.gibuhagae.gibuhagae.productManagement.dto.ItemDTO;
import com.gibuhagae.gibuhagae.productManagement.dto.ProductManagementDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProductDetailDTO {
   private int optionCode;
   private int itemCode;
   private int count;
   private String optionName;
   private int salePrice;
   private Date registDate;
   private ProductManagementDTO productManagementList;

}
