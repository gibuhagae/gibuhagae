package com.gibuhagae.gibuhagae.member.service;

import com.gibuhagae.gibuhagae.common.member.MemberWithdrawFailException;
import com.gibuhagae.gibuhagae.member.dao.MemberMapper;
import com.gibuhagae.gibuhagae.member.dto.CustomUserDTO;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AuthenticationService implements UserDetailsService {
    private final MemberMapper memberMapper;

    public AuthenticationService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String memberId) {
        System.out.println("loadUserByUsername 호출");

        log.info("memberId : {}", memberId);

        MemberDTO findMember = memberMapper.findMemberById(memberId);

        log.info("findMember : {}", findMember);

        System.out.println("로그인 시도");

        if(findMember == null) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        if(findMember.getActivationStatus().equals("N")) {
            throw new UsernameNotFoundException("회원 정보가 존재하지 않습니다");
        }

        log.info("member : {}", findMember);

        /* 권한 리스트 만들기 */
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + findMember.getUserCode()));

        log.info("처리전");

        /* UserDetails를 구현한 User 객체에 id, pwd, 권한을 전달해서 객체를 생성하고 반환한다. */
        //return new User(findMember.getUserId(), findMember.getPassword(), authorities);

        /* User 객체에는 담을 수 없는 추가 정보를 User를 상속한 CustomUser로 처리한다. */
        return new CustomUserDTO(findMember, authorities);
    }
}
