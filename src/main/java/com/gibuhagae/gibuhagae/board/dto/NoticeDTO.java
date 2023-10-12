package com.gibuhagae.gibuhagae.board.dto;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class NoticeDTO {

    private Long noticeNo;          //공지번호
    private String noticeTitle;     //공지제목
    private String noticeContent;   //공지내용
    private MemberDTO memberNo;     //회원번호(작성자)
    private int views;              //조회수
    private Date writeDate;         //작성일자
    private Date updateDate;        //수정일자
    private Date deleteDate;        //삭제일자(비활성화일자)
    private String status;          //상태
}