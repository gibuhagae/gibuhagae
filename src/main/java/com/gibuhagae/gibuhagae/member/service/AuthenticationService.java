package com.gibuhagae.gibuhagae.member.service;

import com.gibuhagae.gibuhagae.member.dao.MemberMapper;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {
    private final MemberMapper memberMapper;

    public AuthenticationService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException  {
        System.out.println("loadUserByUsername 호출");
        
        log.info("memberId : {}", memberId);

        MemberDTO findMember = memberMapper.findMemberById(memberId);

        if(findMember == null) throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");

        log.info("member : {}", findMember);

        return findMember;
    }
}
