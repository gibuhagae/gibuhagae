package com.gibuhagae.payment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class paymentController {

    @GetMapping("/payment")
    public String getPayment() {

        return "payment/payment";
    }
}
