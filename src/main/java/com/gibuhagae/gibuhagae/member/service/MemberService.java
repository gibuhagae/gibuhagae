package com.gibuhagae.gibuhagae.member.service;

import com.gibuhagae.gibuhagae.member.dao.MemberMapper;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import com.gibuhagae.gibuhagae.member.dto.MemberFunctionInfosDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public boolean modifyMemberInfo(String id, String pwd, String phone1, String phone2, String phone3,
                                String zipCode, String addr1, String addr2, String email) {
        // 번호 취합
        final String PHONE = phone1 + " - " + phone2 + " - " + phone3;
        System.out.println("취합된 휴대폰 번호: " + PHONE);

        // 주소 취합
        final String ADDRESS = addr1 + '*' +  addr2;
        System.out.println("취합된 주소: " + ADDRESS);

        MemberDTO member = new MemberDTO();
        member.setUserId(id);
        if (pwd != null && !pwd.equals("")) {
            System.out.println("수정된 비밀번호= " + pwd);
            member.setPassword(passwordEncoder.encode(pwd));
        }
        member.setMemberPhone(PHONE);
        member.setZipcode(zipCode);
        member.setAddress(ADDRESS);
        member.setEmail(email);

        int ret = memberMapper.modifyMemberInfo(member);
        System.out.println(ret);
        return ret > 0;
    }

    @Transactional
    public boolean joinMember(MemberDTO member, String memberPhone2, String memberPhone3, String address, String rAddress) {
        System.out.println("가공전: " + member.toString());

        modifyInaccurateMemberData(member, memberPhone2, memberPhone3, address, rAddress);

        /* 평문으로 된 비밀번호를 암호화한다. */
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        log.info("비밀번호 암호화 되었다.");

        log.info("암호화된 비밀번호" + member.getPassword());

        /* tbl_member 테이블에 정보 저장 */
        memberMapper.registMember(member);

        log.info("회원가입 DB 처리 완료");

        return true;
    }

    @Transactional
    public List<MemberDTO> selectFindIdInfos(String mName, String mEmail) {

        List<MemberDTO> nameAndEmailList = memberMapper.selectFindIdInfos(mName, mEmail);
        if (nameAndEmailList == null) {
            System.out.println("문제 있다.");
            return null;
        }

        return nameAndEmailList;
    }

    @Transactional
    public MemberDTO selectFindPwdInfos(String mId, String mName, String mEmail) {
        MemberDTO IdAndNameAndEmail = memberMapper.selectFindPwdInfos(mId, mName, mEmail);
        if (IdAndNameAndEmail == null) {
            System.out.println("문제 있다.");
            return null;
        }

        return IdAndNameAndEmail;
    }

    private void modifyInaccurateMemberData(MemberDTO member, String memberPhone2, String memberPhone3, String address, String rAddress) {

        // 번호 취합
        final String PHONE = member.getMemberPhone().trim() + " - " + memberPhone2 + " - " + memberPhone3;
        System.out.println("취합된 휴대폰 번호: " + PHONE);

        // 주소 취합
        final String ADDRESS = address.trim() + '*' +  rAddress.trim();
        System.out.println("취합된 주소: " + ADDRESS);

        // 공백이 포함되지 않게 정보들을 재가공한다.
        member.setUserId(member.getUserId().trim());
        member.setPassword(member.getPassword().trim());
        member.setMemberName(member.getMemberName().trim());
        member.setMemberPhone(PHONE);
        if (member.getZipcode() == null)
            member.setZipcode("");
        member.setZipcode(member.getZipcode().trim());
        member.setAddress(ADDRESS);
        member.setEmail(member.getEmail().trim());

        System.out.println("가공후: " + member.toString());
    }

    public boolean selectMemberId(String userId) {

        String result = memberMapper.selectMemberId(userId);

        return result != null;
    }

    public String[] generateSplitStr(String str, String keyword) {
        String strs[] = str.split(keyword);
        return strs;
    }

    public String generatePwd() {
        // 8 ~ 16자의 숫자 + 영문 조합을 생성한다.

        // 임시 비밀번호 객체를 생성한다.
        StringBuilder tempPwd = new StringBuilder();

        // 8 ~ 16자의 자릿수 랜덤 생성
        final int PWD_LEN = (int)(Math.random() * 9 + 8);

        // 각 자릿수에 숫자 | 대 | 소문자 Char 값을 넣는다.
        for(int i = 0; i < PWD_LEN; i++) {
            char selectedVal = ' ';
            switch ((int)(Math.random() * 3)) {
                // 숫자
                case 0:
                    selectedVal = (char)((int)(Math.random() * 9 + 1) + '0');
                    break;
                // 소문자    26
                case 1:
                    int lAlphabet = (int)(Math.random() * 25 + 65);
                    selectedVal = (char)(lAlphabet);
                    break;
                // 대문자
                case 2:
                    int bAlphabet = (int)(Math.random() * 25 + 97);
                    selectedVal = (char)(bAlphabet);
                    break;
            }

            tempPwd.append(selectedVal);
        }

        return tempPwd.toString();
    }

    public boolean modifyMemberPwdByUserId(String userId, String password) {

        int ret = 0;
        ret = memberMapper.modifyMemberPwdById(userId, password);

        return ret > 0;
    }

    public MemberDTO getMemberById(String userId) {
        return memberMapper.findMemberById(userId);
    }

    @Transactional
    public void removeMember(String memberId) {
        int result = memberMapper.deleteMember(memberId);

        if(!(result > 0)) {
            System.out.println("회원 탈퇴에 실패하셨습니다.");
        }
    }
}
