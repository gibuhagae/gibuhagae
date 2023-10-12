package com.gibuhagae.gibuhagae.member.service;

import com.gibuhagae.gibuhagae.common.exception.member.MemberModifyException;
import com.gibuhagae.gibuhagae.common.exception.member.MemberRegistException;
import com.gibuhagae.gibuhagae.common.exception.member.MemberRemoveException;
import com.gibuhagae.gibuhagae.common.paging.Pagenation;
import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import com.gibuhagae.gibuhagae.member.dao.MemberMapper;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Map<String, Object> selectMemberList(Map<String, String> searchMap, int page) {

        /* 전체 회원 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = memberMapper.selectTotalCount(searchMap);
        log.info("memberList totalCount : {}", totalCount);


        /* 페이징 처리와 연관된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10; // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5; // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);


        /* 요청 페이지와 검색 기준에 맞는 회원을 조회해온다.*/
        List<MemberDTO> memberList = memberMapper.selectMemberList(selectCriteria);
        log.info("memberList totalCount : {}", memberList);

        Map<String, Object> memberListAndPaging = new HashMap<>();
        memberListAndPaging.put("paging", selectCriteria);
        memberListAndPaging.put("memberList", memberList);


        return memberListAndPaging;
    }

    /* 관리자 회원 insert*/
    public void insertMember(MemberDTO member) throws MemberRegistException {

        int result = memberMapper.insertMember(member);

        if(!(result > 0)) throw new MemberRegistException("회원 가입에 실패하였습니다.");
    }

    /* id 중복체크 - id 가져오기*/
    public boolean selectMemberByUserId(String userId) {

        String result = memberMapper.selectMemberByUserId(userId);

        return result != null;
    }


    /* 회원 상세 정보 조회 및 수정 */
    public void modifyMember(MemberDTO member) throws MemberModifyException {

        int result = memberMapper.modifyMember(member);

        if(!(result > 0)) throw new MemberModifyException("회원 정보 수정 실패");
    }
}
