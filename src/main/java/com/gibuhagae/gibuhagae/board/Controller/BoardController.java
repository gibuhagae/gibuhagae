package com.gibuhagae.gibuhagae.board.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/notice")
    public String getNotice(){

        return "/board/notice/notice";
    }
    @GetMapping("/qna")
    public String getQna(){

        return "/board/qna/qna";
    }
    @GetMapping("/review")
    public String getReview(){

        return "/board/review/review";
    }
}
