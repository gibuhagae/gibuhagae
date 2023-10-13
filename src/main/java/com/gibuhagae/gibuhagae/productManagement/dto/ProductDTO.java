package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductDTO {

    private Long itemCode;
    private String itemName;
    private String saleStatus;
    private Date registDate;
    private int categoryCode;
    private CategoryDTO category;
    private int totalCount;
    private List<OptionDTO> option;
    private List<AttachmentDTO> attachmentList;

}
