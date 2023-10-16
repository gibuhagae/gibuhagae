package com.gibuhagae.gibuhagae.productDetail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ProductDetailController {

    @GetMapping("/itemPage")
    public String addPage() {

        return "basket/product";
    }
}
