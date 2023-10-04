package com.gibuhagae.gibuhagae.productManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productManagement")
public class ProductController {

    @GetMapping("/product-admin")
    public String getProduct() {

        return "productManagement/product-admin";
    }
}
