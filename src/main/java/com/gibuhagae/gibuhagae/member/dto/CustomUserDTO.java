package com.gibuhagae.gibuhagae.member.dto;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

@Getter
@ToString
public class CustomUserDTO extends User {
    private int no;
    private String name;
    private Date registDate;

    public CustomUserDTO(MemberDTO member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getUserId(), member.getPassword(), authorities);
        setDetails(member);
    }

    private void setDetails(MemberDTO member) {
        this.no = member.getMemberNo();
        this.name = member.getMemberName();
        this.registDate = member.getRegistDate();
    }
}
