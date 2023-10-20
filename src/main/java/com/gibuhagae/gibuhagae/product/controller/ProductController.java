package com.gibuhagae.gibuhagae.product.controller;

import com.gibuhagae.gibuhagae.basket.dto.BasketDTO;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
import com.gibuhagae.gibuhagae.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/productList")
    public String getProduct(@RequestParam(defaultValue = "1") int page,
                             Model model){


        Map<String, Object> productListAndPaging = productService.selectProduct(page);

        model.addAttribute("paging", productListAndPaging.get("paging"));
        model.addAttribute("itemList", productListAndPaging.get("itemList"));

        return "product/productList";
    }

    @GetMapping("/productDetail")
    public String getProductDetail(@RequestParam Long no, Model model){

        ItemDTO itemDetail = productService.selectProductDetail(no);


        BasketDTO basketDTO = new BasketDTO();

        model.addAttribute("item", itemDetail);
        model.addAttribute("basket", basketDTO);

        return "product/productDetail";
    }





}
