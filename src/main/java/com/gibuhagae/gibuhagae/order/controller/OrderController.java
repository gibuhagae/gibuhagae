package com.gibuhagae.gibuhagae.order.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.order.dto.OrderManagementDTO;
import com.gibuhagae.gibuhagae.order.service.OrderService;
import com.gibuhagae.gibuhagae.productManagement.dto.ItemDTO;
import com.gibuhagae.gibuhagae.productManagement.dto.ItemOptionDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Session;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping("/order-new")
    public void getNewOrderList(Model model) {


        List<OrderManagementDTO> newOrderList = orderService.selectNewOrderList();

        model.addAttribute("newOrderList", newOrderList);



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
