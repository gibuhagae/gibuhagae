package com.gibuhagae.gibuhagae.attachment.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* 업로드 된 파일과 관련한 정보를 모아서 관리하는 DTO */
@Getter
@Setter
@ToString
public class AttachmentDTO {

    private Long fileNo;        //파일번호
    private String fileName;    //파일명
    private String filePath;    //경로명
    private String fileSave;    //저장명
    private String fileExt;     //확장자명
    private  String fileVolume; //용량
    private String fileType;    //구분
    private Long itemCode;      //상품코드
    private Long reviewNo;      //리뷰번호
    private Long inquiryNo;     //문의번호
    private Long bannerNo;      //배너번호
    private Long refundNo;      //환불번호
}
