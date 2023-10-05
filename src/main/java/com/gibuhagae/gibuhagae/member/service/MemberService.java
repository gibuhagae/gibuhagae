package com.gibuhagae.gibuhagae.member.service;

import com.gibuhagae.gibuhagae.member.dao.MemberMapper;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class MemberService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberMapper memberMapper, PasswordEncoder passwordEncoder) {
        this.memberMapper = memberMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void joinMember(MemberDTO member) {
        System.out.println("가공전: " + member.toString());

        modifyInaccurateMemberData(member);

        /* 평문으로 된 비밀번호를 암호화한다. */
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        log.info("비밀번호 암호화 되었다.");

        log.info("암호화된 비밀번호" + member.getPassword());

        member.setRegistDate(new Date());
        member.setUpdateDate(new Date());

        member.setDonatePrice("1");

        member.setUserCode(1L);

        member.setLoginType("1");
        member.setActivationStatus("s");

        /* tbl_member 테이블에 정보 저장 */
        memberMapper.registMember(member);

        log.info("회원가입 DB 처리 완료");
    }

    private void modifyInaccurateMemberData(MemberDTO member) {

        // 공백이 포함되지 않게 정보들을 재가공한다.
        member.setUserId(member.getUserId().trim());
        member.setPassword(member.getPassword().trim());
        member.setMemberName(member.getMemberName().trim());
        member.setMemberPhone(member.getMemberPhone().trim());
        member.setAddress(member.getAddress().trim());
        member.setEmail(member.getEmail().trim());

        System.out.println("가공후: " + member.toString());

    }
}
