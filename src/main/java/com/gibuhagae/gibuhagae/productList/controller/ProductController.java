package com.gibuhagae.gibuhagae.productList.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productList")
public class ProductController {

    @GetMapping("/product")
    public String getProduct(){

        return "productList/product";
    }


}
