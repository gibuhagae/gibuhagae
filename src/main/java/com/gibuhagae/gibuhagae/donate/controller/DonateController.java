package com.gibuhagae.gibuhagae.donate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donate")
public class DonateController {

    @GetMapping("/donate-admin")
    public String getDonate() {

        return "donate/donate-admin";
    }
}
