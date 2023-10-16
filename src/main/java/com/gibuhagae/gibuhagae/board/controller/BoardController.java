package com.gibuhagae.gibuhagae.board.controller;

import com.gibuhagae.gibuhagae.board.dto.NoticeDTO;
import com.gibuhagae.gibuhagae.board.dto.QnaDTO;
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

    @GetMapping("/noticeDetail")
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

    @PostMapping("/noticeDetail")
    public String updateNotice(@RequestParam("noticeNo") Long noticeNo, @ModelAttribute("notice") NoticeDTO notice) {

        boardService.updateNotice(notice);

        return "redirect:/board/notice";
    }

    @GetMapping("/detail")
    public String deleteNotice(Long no){

        boardService.deleteNotice(no);

        return "redirect:/board/notice";
    }


    @GetMapping("/qna")             // 기본 페이지는 1페이지로
    public String getQna(@RequestParam(defaultValue = "1") int page,
                            Model model){

        Map<String, Object> qnaListAndPaging = boardService.selectQna(page);

        model.addAttribute("paging", qnaListAndPaging.get("paging"));
        model.addAttribute("qnaList", qnaListAndPaging.get("qnaList"));

        return "board/qna";
    }

    @GetMapping("/qnaDetail")
    public String getQnaDetail(@RequestParam Long no, Model model){

        QnaDTO qnaDetail = boardService.selectQnaDetail(no);
        model.addAttribute("qna", qnaDetail);

        return "board/qnaDetail";
    }

    @PostMapping("/qna")
    public String registQna(QnaDTO qna, @AuthenticationPrincipal MemberDTO memberNo){

        qna.setMemberNo(memberNo);
        boardService.registQna(qna);

        return "redirect:/productDetail/productDetail#qna";
    }

@GetMapping("/review")             // 기본 페이지는 1페이지로
public String getReview(@RequestParam(defaultValue = "1") int page,
                     Model model){

    Map<String, Object> reviewListAndPaging = boardService.selectReview(page);

    model.addAttribute("paging", reviewListAndPaging.get("paging"));
    model.addAttribute("reviewList", reviewListAndPaging.get("reviewList"));

    return "board/review";
}



}
