package com.gibuhagae.gibuhagae.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberFunctionInfosDTO {
    private String MemberId;
    private boolean isSavedId;
    private boolean isRememberedId;
}
