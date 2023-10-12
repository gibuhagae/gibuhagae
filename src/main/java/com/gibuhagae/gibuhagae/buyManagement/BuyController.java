package com.gibuhagae.gibuhagae.buyManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(("/buyManagement"))
public class BuyController {

    @GetMapping("/buy-admin")
    public String getBuyPage(){
        return "/buy/buy-admin";
    }

}
