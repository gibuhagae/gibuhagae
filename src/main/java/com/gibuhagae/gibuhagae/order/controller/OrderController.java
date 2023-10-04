package com.gibuhagae.gibuhagae.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/order-new")
    public String getOrderNew() {

        return "/order/order-new";
    }

    @GetMapping("/order-ready")
    public String getOrderReady () {

        return "/order/order-ready";
    }

    @GetMapping("/order-shipping")
    public String getOderShipping () {

        return "/order/order-shipping";
    }

    @GetMapping("/order-complete")
    public String getOderComplete () {

        return "/order/order-complete";
    }

    @GetMapping("/order-cancel")
    public String getOderCancel () {

        return "/order/order-cancel";
    }

    @GetMapping("/order-return")
    public String getOrderReturn () {

        return "/order/order-return";
    }

    @GetMapping("/order-swap")
    public String getOrderSwap () {

        return "/order/order-swap";
    }
}
