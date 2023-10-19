package com.gibuhagae.gibuhagae.basket.controller;

import com.gibuhagae.gibuhagae.basket.dao.BasketMapper;
import com.gibuhagae.gibuhagae.basket.dto.BasketDTO;
import com.gibuhagae.gibuhagae.basket.service.BasketService;
import com.gibuhagae.gibuhagae.productDetail.dto.ProductDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class BasketController {

    private final BasketMapper basketMapper;
    private final BasketService basketService;

    public BasketController(BasketMapper basketMapper, BasketService basketService) {
        this.basketMapper = basketMapper;
        this.basketService = basketService;
    }

    @GetMapping("/basket")
    public String basketList(Model model) {

        int memberNo = 1;

        Map<String, Integer> map = new HashMap<>();
        map.put("memberNo", memberNo);

        List<BasketDTO> basket = basketService.selectItems(map);
        model.addAttribute("basket", basket);

        return "basket/basket";
    }

    @PostMapping("/basket/regist")
    public ResponseEntity<String> addBasket(@RequestBody BasketDTO basket) {
        System.out.println("h2");
        System.out.println("basket" + basket);

        String abc = "성공";

        if (basketService.addBasket(basket) == false) {

            abc = "실패";
        }

        return ResponseEntity.ok(abc);
    }

    @GetMapping("/productPage")
    public String selectItemOption(Model model) {

        int itemCode = 1;
        Map<String, Integer> map = new HashMap<>();
        map.put("itemCode", itemCode);

        ProductDetailDTO productDetail = basketService.selectOption(map);
        model.addAttribute("productDetail", productDetail);

        return "basket/product";
    }

    @PostMapping("/quantity/plus")
    public ResponseEntity<String> plusClicked(@RequestParam String basketNo) {

        //json 호출
        System.out.println(basketNo);
        basketService.plusClicked(Integer.parseInt(basketNo));

       return ResponseEntity.ok("성공");
    }

    @PostMapping("/quantity/minus")
    public ResponseEntity<String> minusClicked(@RequestParam String basketNo) {

        //json 호출
        System.out.println(basketNo);
        basketService.minusClicked(Integer.parseInt(basketNo));

        return ResponseEntity.ok("성공");
    }

    @PostMapping("/quantity/changed")
    public ResponseEntity<String> qtyChanged(@RequestParam String basketNo, @RequestParam int count) {

        //json 호출
        System.out.println(basketNo);
        basketService.qtyChanged(Integer.parseInt(basketNo));

        return ResponseEntity.ok("성공");
    }

    @PostMapping("/select/button")
    public ResponseEntity<String> selectDel(@RequestParam String basketNo) {

        //json 호출
        System.out.println(basketNo);
        basketService.selectDel(Integer.parseInt(basketNo));

        return ResponseEntity.ok("성공");
    }

    @PostMapping("/clear/cart")
    public ResponseEntity<String> clearCart(@RequestParam String memberNo) {

        memberNo = "1";
        System.out.println(memberNo);
        basketService.clearCart(Integer.parseInt(memberNo));

        return ResponseEntity.ok("삭제 성공");
    }

}
