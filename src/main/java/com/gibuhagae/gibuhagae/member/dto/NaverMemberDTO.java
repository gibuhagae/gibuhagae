package com.gibuhagae.gibuhagae.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class NaverMemberDTO {
    private String id;
    private String gender;
    private String name;
    private String nickname;
    private int age;
    private String email;
    private String phone;
    private String loginType;
    private String token;

    public NaverMemberDTO(String id, String gender, String name, String nickname, int age, String email, String phone, String loginType, String token) {
        this.id = id;
        this.gender = gender;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.loginType = loginType;
        this.token = token;
    }
}
