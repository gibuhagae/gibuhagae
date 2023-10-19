package com.gibuhagae.gibuhagae.member.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@ToString
public class MemberDTO  implements UserDetails {
    private int memberNo;
    private String memberName;
    private String memberPhone;
    private String zipcode;
    private String address;
    private Date registDate;
    private Date updateDate;
    private String email;
    private String donatePrice;
    private String password;
    private String userId;
    private String userCode;
    private String loginType;
    private String activationStatus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
