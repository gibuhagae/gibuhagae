package com.gibuhagae.gibuhagae.board.Controller.review;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ReviewDTO {

    private int reviewNo;           //리뷰번호
    private String reviewTitle;     //리뷰제목
    private int grade;              //평점
    private MemberDTO memberNoo;    //회원번호(작성자)
    private Date registDate;        //등록일
    private Date updateDate;        //수정일
    private Date deleteDate;        //삭제일
    private Long itemCode;          //상품코드
    private Long optionCode;        //옵션코드
    private String showStatus;      //상태

}
