package com.gibuhagae.gibuhagae.productManagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AttachmentDTO {

    private int fileNo;
    private String fileName;
    private String filePath;
    private String fileSave;
    private String fileExt;
    private String fileVolume;
    private String fileType;
    private int itemCode;
    private int reviewNo;
    private int inquiryNo;
    private int bannerNo;
    private int refundNo;
}
