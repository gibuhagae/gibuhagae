package com.gibuhagae.gibuhagae.totalSales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/totalSales")
public class TotalSaleController {

    @GetMapping("/totalSale-admin")
    public String getTotalSale() {

        return "totalSales/totalSales-admin";
    }
}
