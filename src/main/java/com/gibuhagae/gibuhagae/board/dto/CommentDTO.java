package com.gibuhagae.gibuhagae.board.dto;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;

import java.util.Date;

public class CommentDTO {

    private Long commentNo;
    private String commentContent;
    private String commentStatus;
    private MemberDTO memberNo;
    private Date deleteDate;
    private Date registDate;
    private Date updateDate;
    private String showStatus;
    private Long inquiryNo;
    private Long reviewNo;
}
