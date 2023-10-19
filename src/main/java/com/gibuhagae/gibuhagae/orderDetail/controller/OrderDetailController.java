package com.gibuhagae.gibuhagae.orderDetail.controller;

import com.gibuhagae.gibuhagae.basket.dto.BasketDTO;

import com.gibuhagae.gibuhagae.basket.dto.BasketItemDTOList;
import com.gibuhagae.gibuhagae.orderDetail.dao.OrderDetailMapper;
import com.gibuhagae.gibuhagae.orderDetail.dto.OrderDetailDTO;
import com.gibuhagae.gibuhagae.orderDetail.service.OrderDetailService;
import com.gibuhagae.gibuhagae.orderManagement.dto.OrderManagementDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class OrderDetailController {

    private final OrderDetailMapper orderDetailMapper;
    private final OrderDetailService orderDetailService;

    public OrderDetailController(OrderDetailMapper orderDetailMapper, OrderDetailService orderDetailService) {
        this.orderDetailMapper = orderDetailMapper;
        this.orderDetailService = orderDetailService;
    }

    @PostMapping("/basket/items")
    public String orderBasket(BasketItemDTOList basketItemList,
                              Model model) {

        System.out.println(basketItemList.getBasketItems());

        model.addAttribute("itemList", basketItemList);

        return "payment/payment";

    }
}