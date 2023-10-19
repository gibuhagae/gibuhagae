package com.gibuhagae.gibuhagae.payment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class deliveryAddressDTO {
    private int deliveryCode;
    private String memberName;
    private String zipcode;
    private String address;
    private String addressDetail;
    private String phone;
    private String deleveryRequest;
    private String addressDefaultCk;
    private int memberNo;

}
