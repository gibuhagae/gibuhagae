package com.gibuhagae.gibuhagae.mainPage.controller;

import com.gibuhagae.gibuhagae.mainPage.service.MainService;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
@Slf4j
@Controller
public class MainPageController {

    private final MainService mainService;

    public MainPageController(MainService mainService){
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String getMainProduct(Model model) {

        List<ItemDTO> itemList = mainService.selectItems();

        model.addAttribute("itemList", itemList);

        return "/index";
    }

}
