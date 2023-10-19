package com.gibuhagae.gibuhagae.myPage.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MyPageOrderDetailDTO {
    // 주문일자/주문번호
    private String orderDateAndN;
    // 이미지 NULL
    private String imageSrc;
    // 상품정보
    private String itemInfo;
    // 수량
    private int itemCnt;
    // 상품구매금액
    private int paymentPrice;
    // 주문처리상태
    private String orderStatus;
    // 취소/교환/반품
    private String statusOfCER;
}
