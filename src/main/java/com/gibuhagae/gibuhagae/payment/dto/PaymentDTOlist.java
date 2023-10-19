package com.gibuhagae.gibuhagae.payment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PaymentDTOlist {

    private int itemCode;
    private int optionCode;
    private int count;
    private int itemPrice;
    private String itemImg;
}
