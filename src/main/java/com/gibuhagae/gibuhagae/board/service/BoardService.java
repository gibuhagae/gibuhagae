package com.gibuhagae.gibuhagae.board.service;

import com.gibuhagae.gibuhagae.board.dao.BoardMapper;
import com.gibuhagae.gibuhagae.board.dto.NoticeDTO;
import com.gibuhagae.gibuhagae.board.dto.QnaDTO;
import com.gibuhagae.gibuhagae.common.paging.Pagenation;
import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
public class BoardService {

    /* 생성자를 이용한 의존성 주입 */
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public Map<String, Object> selectNotice(int page) {

        /* 페이징 처리를 위한 전체 게시글 수 확인 */
        int totalCount = boardMapper.selectTotalCount();

        /* 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담기 */
        int limit = 10;          // 한 페이지에 보여 줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

        /* 요청 페이지 게시글을 조회 */
        List<NoticeDTO> noticeList = boardMapper.selectNoticeList(selectCriteria);

        Map<String, Object> noticeListAndPaging = new HashMap<>();
        noticeListAndPaging.put("paging", selectCriteria);
        noticeListAndPaging.put("noticeList", noticeList);

        return noticeListAndPaging;

    }

    public NoticeDTO selectNoticeDetail(Long no) {

        /* 조회수 증가 로직 호출 */
        boardMapper.incrementNoticeCount(no);

        /* 게시글 상세 내용 조회 후 리턴 */
        return boardMapper.selectNoticeDetail(no);
    }

    public void registNotice(NoticeDTO notice) {

        boardMapper.insertNotice(notice);
    }

    public void updateNotice(NoticeDTO notice) {

        boardMapper.updateNotice(notice);

    }

    public Map<String, Object> selectQna(int page) {

        /* 페이징 처리를 위한 전체 게시글 수 확인 */
        int totalCount = boardMapper.selectQnaTotalCount();

        /* 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담기 */
        int limit = 10;          // 한 페이지에 보여 줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount);

        /* 요청 페이지 게시글을 조회 */
        List<QnaDTO> qnaList = boardMapper.selectQnaList(selectCriteria);

        Map<String, Object> qnaListAndPaging = new HashMap<>();
        qnaListAndPaging.put("paging", selectCriteria);
        qnaListAndPaging.put("qnaList", qnaList);

        return qnaListAndPaging;
    }

    public QnaDTO selectQnaDetail(Long no) {

        /* 게시글 상세 내용 조회 후 리턴 */
        return boardMapper.selectQnaDetail(no);
    }


//    public void deleteNotice(Long no) {
//
//        boardMapper.deleteNotice(no);
//    }
}
