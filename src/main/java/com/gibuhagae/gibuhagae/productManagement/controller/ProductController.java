package com.gibuhagae.gibuhagae.productManagement.controller;

import com.gibuhagae.gibuhagae.common.exception.member.MemberRegistException;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.productManagement.dto.ProductDTO;
import com.gibuhagae.gibuhagae.productManagement.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/productManagement")
public class ProductController {

    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    /* 상품 리스트 조회 */
    @GetMapping("/product-admin")
    public String getProductList(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(required = false) String searchCondition,
                                 @RequestParam(required = false) String searchValue,
                                 Model model) {

        log.info("productList page : {}", page);
        log.info("productList searchCondition : {}", searchCondition);
        log.info("productList searchValue : {}", searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> productListAndPaging =  productService.selectProductList(searchMap, page);

        model.addAttribute("paging", productListAndPaging.get("paging"));
        model.addAttribute("productList", productListAndPaging.get("productList"));


        return "/productManagement/productList";
    }

    /* 상품 insert */
    @PostMapping("/insert")
    public String insertMember(@ModelAttribute ProductDTO product, String category1, String category2,
                               RedirectAttributes rttr) throws MemberRegistException {

//        String address =  address1 + "$" + address2;
//        member.setAddress(address);
//        member.setPassword(passwordEncoder.encode(member.getPassword()));
//        member.setUserCode("ADMIN");
//        member.setLoginType("일반");
//        member.setActivationStatus("Y");
//
//        memberService.insertMember(member);
//
//        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.insert"));

        return "redirect:/memberManagement/member-admin";
    }
}
