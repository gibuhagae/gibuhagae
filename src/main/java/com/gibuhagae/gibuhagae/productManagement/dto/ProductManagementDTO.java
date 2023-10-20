package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ProductManagementDTO {
    private Long itemCode;
    private String itemName;
    private String saleStatus;
    private Date registDate;
    private List<AttachmentDTO> attachmentList;
}
