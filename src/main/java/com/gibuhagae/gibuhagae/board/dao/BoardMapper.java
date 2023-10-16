package com.gibuhagae.gibuhagae.board.dao;

import com.gibuhagae.gibuhagae.board.dto.NoticeDTO;
import com.gibuhagae.gibuhagae.board.dto.QnaDTO;
import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    int selectTotalCount();

    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    void incrementNoticeCount(Long no);

    NoticeDTO selectNoticeDetail(Long no);

    void insertNotice(NoticeDTO notice);

    void updateNotice(NoticeDTO notice);

//    void deleteNotice(Long no);

    int selectQnaTotalCount();

    List<QnaDTO> selectQnaList(SelectCriteria selectCriteria);


    void incrementQnaCount(Long no);


    QnaDTO selectQnaDetail(Long no);
}
