package com.gibuhagae.gibuhagae.basket.service;

import com.gibuhagae.gibuhagae.basket.dao.BasketMapper;
import com.gibuhagae.gibuhagae.basket.dto.BasketDTO;
import com.gibuhagae.gibuhagae.basket.dto.BasketItemDTO;
import com.gibuhagae.gibuhagae.productDetail.dto.ProductDetailDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BasketService {

    private final BasketMapper basketMapper;

    public BasketService(BasketMapper basketMapper) {
        this.basketMapper = basketMapper;
    }

    public List<BasketDTO> selectItems(Map<String, Integer> map) {

        List<BasketDTO> basketDTO = basketMapper.selectItems(map);
        if (basketDTO == null) {
            System.out.println("객체 NULL!");
            return null;
        }

        return basketDTO;
    }

    public ProductDetailDTO selectOption(Map<String, Integer> map) {

        ProductDetailDTO productDetailDTO = basketMapper.selectOption(map);
        if (productDetailDTO == null) {
            System.out.println("아이템없음");
            return null;
        }
        return productDetailDTO;
    }

    public boolean addBasket(BasketDTO basket) {

//        basket.setItemCode(5);
//        basket.setOptionCode(1);

        if(basketMapper.checkCart(basket)) {

            System.out.println("들어감");
            return false;
        }

        basketMapper.addBasket(basket);

        return true;

    }

    public void plusClicked(int basketNo) {

        basketMapper.plusClicked(basketNo);
    }


    public void minusClicked(int basketNo) {

        basketMapper.minusClicked(basketNo);
    }

    public void clearCart(int memberNo) {

        basketMapper.clearCart(memberNo);
    }

    public void selectDel(int basketNo) {

        basketMapper.selectDel(basketNo);
    }

    public void qtyChanged(int basketNo) {

        basketMapper.qtyChanged(basketNo);
    }

}
