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
public class QnaDTO {

    private int inquiryNo;          //문의번호
    private String inquiryType;     //문의유형
    private String inquiryTitle;     //문의제목
    private String inquiryContent;  //문의내용
    private ItemDTO itemCode;          //상품코드
    private MemberDTO memberNo;     //회원번호
    private Date writeDate;         //작성일시
    private Date updateDate;        //수정일시
    private Date deleteDate;        //삭제일시
    private String status;    //답변상태
}
