package com.gibuhagae.gibuhagae.order.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter @Setter @ToString
public class CancelListDTO {
    private Long orderNo;
    private Date orderDate;
    private int orderCount;
    private String itemName;
    private String optionName;
    private int paymentPrice;
    private String recipientName;
    private String userId;
    private Date cancelDate;


}
