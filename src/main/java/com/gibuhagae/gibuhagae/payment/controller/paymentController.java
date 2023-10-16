package com.gibuhagae.gibuhagae.payment.controller;

import com.gibuhagae.gibuhagae.payment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class paymentController {

    @GetMapping("/payment")
    public String getCompletePayment() {

        return "payment/payment";
    }

    @GetMapping("/paymentModal")
    public String getPaymentModal() {
        return "payment/paymentModal";
    }
}
