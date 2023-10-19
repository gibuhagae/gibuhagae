package com.gibuhagae.gibuhagae.basket.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @ToString
public class BasketItemDTOList {

    private List<BasketItemDTO> basketItems;

    public BasketItemDTOList() {
        basketItems = new ArrayList<>();
    }
}
