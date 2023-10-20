package com.gibuhagae.gibuhagae.basket.dto;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
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
    private Long basketNo;
    private Long count;
    private ProductDetailDTO optionDetailCode;
    private MemberDTO member;
    private int memberNo;
    private Long optionCode;
    private Long itemCode;
    private List<BasketDTO> basketItems;
}
