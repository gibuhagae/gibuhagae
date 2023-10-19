package com.gibuhagae.gibuhagae.payment.controller;

import com.gibuhagae.gibuhagae.basket.dto.BasketItemDTO;
import com.gibuhagae.gibuhagae.basket.dto.BasketItemDTOList;
import com.gibuhagae.gibuhagae.payment.dto.PaymentDTO;
import com.gibuhagae.gibuhagae.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class paymentController {

    private final PaymentService paymentService;

    public paymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/paymentModal")
    public String getPaymentModal() {
        return "payment/paymentModal";
    }

    @PostMapping("/payment/confirm")
    public String getOrder(@ModelAttribute PaymentDTO payment,
                           @RequestParam String itemImg,
                           @RequestParam String itemName,
                           @RequestParam String optionName,
                           @RequestParam List<Integer> optionCode,
                           @RequestParam List<Integer> count,
                           @RequestParam List<Integer> itemPrice,
                           @RequestParam List<Integer> itemCode) {

        System.out.println("payment" + payment);
        Date date = new Date();
        int year = date.getYear();
        int month = (date.getMonth() + 1);
        int day = date.getDate();

        int orderNo = year + month + day;
        for(int i =0; i < 10; i++) {
            orderNo += Math.floor(Math.random() * 8);
        }

        payment.setItemCode(itemCode);
        payment.setCount(count);
        payment.setOptionCode(optionCode);
        payment.setItemPrice(itemPrice);

        

        Map<String, Object> map = new HashMap<>();
        map.put("orderNum", orderNo);
        map.put("paymentDTO", payment);

        paymentService.addPayment(payment);

        paymentService.addOrderManagement(payment);

        paymentService.addOrderDetail(payment);

        paymentService.addPost(payment);

        return "completePayment/completePayment";
    }
}



