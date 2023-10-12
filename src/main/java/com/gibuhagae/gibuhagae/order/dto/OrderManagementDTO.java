package com.gibuhagae.gibuhagae.order.dto;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.productManagement.dto.ItemDTO;
import com.gibuhagae.gibuhagae.productManagement.dto.ItemOptionDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
public class OrderManagementDTO {
 private Date orderDate;
 private String orderStatus;
 private int orderCount;
 private String donateYN;
 private String paymentPrice;
 private Long orderNo;
 private Long memberNo;
 private Date cancelDate;
 private String cerStatus;
 private String totalOrderPrice;
 private String donatePrice;

 private String recipientName;
 private String itemName;
 private String optionName;
 private String registrationNo;
 private String postOffice;
 private String deliveryRequest;

 

}
