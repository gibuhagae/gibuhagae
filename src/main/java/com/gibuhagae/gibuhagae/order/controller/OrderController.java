package com.gibuhagae.gibuhagae.order.controller;


import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import com.gibuhagae.gibuhagae.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/order-new")
    public String getNewOrderList(Model model) {


        List<OrderManagementDTO> newOrderList = orderService.selectNewOrderList();

        model.addAttribute("newOrderList", newOrderList);

        return "order/order-new";

    }

    @PostMapping("/order-new")
    public String updatePost(@RequestParam("deliveryCompany") String deliveryCompany,
                             @RequestParam("trackingNumber") String trackingNumber,
                             @RequestParam("selectedOrderNo") String selectedOrderNo,
                             Model model) {


        int trackingN = Integer.parseInt(trackingNumber);

        orderService.updatePost(deliveryCompany, trackingNumber, selectedOrderNo);


        //model.addAttribute("updatePost", orderManagementList);
        return "redirect:order-new";
    }


    @GetMapping("/order-ready")
    public String getOrderReady() {

        return "/order/order-ready";
    }

    @GetMapping("/order-shipping")
    public String getOderShipping() {

        return "/order/order-shipping";
    }

    @GetMapping("/order-complete")
    public String getOderComplete() {

        return "/order/order-complete";
    }

    @GetMapping("/order-cancel")
    public String getOderCancel() {

        return "/order/order-cancel";
    }

    @GetMapping("/order-return")
    public String getOrderReturn() {

        return "/order/order-return";
    }

    @GetMapping("/order-swap")
    public String getOrderSwap() {

        return "/order/order-swap";
    }
}
