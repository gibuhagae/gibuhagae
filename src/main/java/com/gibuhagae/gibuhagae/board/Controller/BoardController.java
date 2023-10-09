package com.gibuhagae.gibuhagae.board.Controller;

import com.gibuhagae.gibuhagae.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @GetMapping("/notice")             // 기본 페이지는 1페이지로
    public String getNotice(@RequestParam(defaultValue = "1") int page,
                            Model model){

        log.info("notice page : {}", page);

        Map<String, Object> noticeListAndPaging = boardService.selectNotice(page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));
        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));

        return "board/notice";
    }




    @GetMapping("/qna")
    public String getQna(){

        return "board/qna";
    }

    @GetMapping("/registQna")
    public String getRegistQna(){

        return "board/registQna";
    }

    @GetMapping("/review")
    public String getReview(){

        return "board/review";
    }
}
