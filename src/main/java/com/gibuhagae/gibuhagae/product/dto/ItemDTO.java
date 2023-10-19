package com.gibuhagae.gibuhagae.product.dto;

import com.gibuhagae.gibuhagae.attachment.dto.AttachmentDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class ItemDTO {

    private Long itemCode;
    private String itemName;
    private String saleStatus;
    private Date registDate;
    private Long categoryCode;
    private Long totalCount;

    private Long refCategoryCode;
    private String optionName;
    private Long salePrice;

    private List<AttachmentDTO> attachmentList;
}
