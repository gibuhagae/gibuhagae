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
   private Long optionCode;
   private Long itemCode;
   private Long count;
   private String optionName;
   private int salePrice;
   private Date registDate;
   private ProductManagementDTO productManagementList;

}
