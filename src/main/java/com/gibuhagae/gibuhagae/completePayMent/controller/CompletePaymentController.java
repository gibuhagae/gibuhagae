package com.gibuhagae.gibuhagae.completePayMent.controller;


import com.gibuhagae.gibuhagae.completePayMent.dto.CompleteDTO;
import com.gibuhagae.gibuhagae.completePayMent.service.CompleteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class CompletePaymentController {

    private final CompleteService completeService;

    public CompletePaymentController(CompleteService completeService) {
        this.completeService = completeService;
    }

    @GetMapping("/completePayment")
    public String getCompletePayment(Model model) {

        int memberNo = 1;

        Map<String, Integer> map = new HashMap<>();
        map.put("memberNo", memberNo);

        List<CompleteDTO> completeDTOList = completeService.selectOrder(map);
        model.addAttribute("orderList", completeDTOList);

        return "completePayment/completePayment";
    }
}
