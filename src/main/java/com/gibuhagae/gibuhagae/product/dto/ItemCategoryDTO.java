package com.gibuhagae.gibuhagae.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemCategoryDTO {

    private Long categoryCode;
    private String categoryName;
    private Long regCategoryCode;
}
