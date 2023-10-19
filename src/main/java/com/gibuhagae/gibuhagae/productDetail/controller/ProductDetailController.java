package com.gibuhagae.gibuhagae.productDetail.controller;

import com.gibuhagae.gibuhagae.board.dto.QnaDTO;
import com.gibuhagae.gibuhagae.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/productDetail")
public class ProductDetailController {

    private final BoardService boardService;

    public ProductDetailController(BoardService boardService) {
        this.boardService = boardService;
    }
    @GetMapping("/productDetail")
    public String getProductDetail(@RequestParam(defaultValue = "1") int page,
                                   Model model){
        Map<String, Object> qnaListAndPaging = boardService.selectQna(page);

        model.addAttribute("paging", qnaListAndPaging.get("paging"));
        model.addAttribute("qnaList", qnaListAndPaging.get("qnaList"));


        return "productDetail/productDetail";
    }

    @GetMapping("/productQnaDetail/{no}")
    public String getProductQnaDetail(@RequestParam Long no, Model model){

        QnaDTO qnaDetail = boardService.selectQnaDetail(no);
        model.addAttribute("qna", qnaDetail);

        return "board/QnaDetail";
    }
}
