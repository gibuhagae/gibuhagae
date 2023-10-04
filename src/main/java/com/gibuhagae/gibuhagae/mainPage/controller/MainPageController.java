package com.gibuhagae.gibuhagae.mainPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainPageController {

    @GetMapping("/index")
    public String getMain() {

        return "main/index";
    }
}
