package com.gibuhagae.gibuhagae.board.Controller.notice;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class NoticeDTO {

private Long no;
private String title;
private String body;
private MemberDTO writer;
private int count;
private Date createDate;
private Date modifyDate;
private String status;
private List<AttachmentDTO> attachmentList;
}
