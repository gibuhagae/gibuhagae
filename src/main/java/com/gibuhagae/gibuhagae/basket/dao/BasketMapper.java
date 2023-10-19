package com.gibuhagae.gibuhagae.basket.dao;

import com.gibuhagae.gibuhagae.basket.dto.BasketDTO;
import com.gibuhagae.gibuhagae.basket.dto.BasketItemDTO;
import com.gibuhagae.gibuhagae.productDetail.dto.ProductDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BasketMapper {

    /* 카트 목록 조회 */
    List<BasketDTO> selectItems(Map<String, Integer> map);

    ProductDetailDTO selectOption(Map<String, Integer> map);

    Boolean checkCart(BasketDTO basket);

    int addBasket(BasketDTO basket);

    void minusClicked(int basketNo);

    void plusClicked(int basketNo);

    void clearCart(int memberNo);

    void selectDel(int basketNo);

    BasketDTO checkBasketById(int basketNo);

    void qtyChanged(int basketNo);

}
