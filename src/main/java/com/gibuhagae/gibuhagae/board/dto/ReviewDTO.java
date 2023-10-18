package com.gibuhagae.gibuhagae.board.dto;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.product.dto.ItemDTO;
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
    private String reviewContent;   //리뷰내용
    private int grade;              //평점
    private MemberDTO memberNo;    //회원번호(작성자)
    private Date registDate;        //등록일
    private Date updateDate;        //수정일
    private Date deleteDate;        //삭제일
    private ItemDTO itemCode;        //상품코드
    private Long optionCode;        //옵션코드
    private String showStatus;      //상태

}
