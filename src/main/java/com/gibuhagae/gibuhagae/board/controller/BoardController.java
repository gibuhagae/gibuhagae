package com.gibuhagae.gibuhagae.board.controller;

import com.gibuhagae.gibuhagae.board.dto.NoticeDTO;
import com.gibuhagae.gibuhagae.board.service.BoardService;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        Map<String, Object> noticeListAndPaging = boardService.selectNotice(page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));
        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));

        return "board/notice";
    }

    @GetMapping("/detail")
    public String getNoticeDetail(@RequestParam Long no, Model model){

        NoticeDTO noticeDetail = boardService.selectNoticeDetail(no);
        model.addAttribute("notice", noticeDetail);
        return "board/noticeDetail";
    }


    /* notice.html과 NoticeMapper.xml을 참조하여 공지글 삽입이 되도록 구현 */
    @PostMapping("/notice")
    public String registNotice(NoticeDTO notice, @AuthenticationPrincipal MemberDTO memberNo){

        notice.setMemberNo(memberNo);
        boardService.registNotice(notice);
        return "redirect:/board/notice";
    }

    @PostMapping("/detail")
    public String updateNotice(@RequestParam("noticeNo") Long noticeNo, @ModelAttribute("notice") NoticeDTO notice) {

        boardService.updateNotice(notice);

        return "redirect:/board/notice";
    }

//    @DeleteMapping("/detail")
//    public String deleteNotice(Long no){
//
//        boardService.deleteNotice(no);
//
//        return "redirect:/board/notice";
//    }


    @GetMapping("/qna")             // 기본 페이지는 1페이지로
    public String getQna(@RequestParam(defaultValue = "1") int page,
                            Model model){
        log.info("------111111 : {}", page);
        Map<String, Object> qnaListAndPaging = boardService.selectQna(page);
        log.info("------2222222 : {}", qnaListAndPaging);
//        model.addAttribute("paging", qnaListAndPaging.get("paging"));
//        model.addAttribute("qnaList", qnaListAndPaging.get("qnaList"));

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
