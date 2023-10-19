package com.gibuhagae.gibuhagae.basket.dto;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.productDetail.dto.ProductDetailDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BasketDTO {
    private int basketNo;
    private int count;
    private ProductDetailDTO optionDetailCode;
    private MemberDTO member;
    private int memberNo;
    private int optionCode;
    private int itemCode;
    private List<BasketDTO> basketItems;
}
