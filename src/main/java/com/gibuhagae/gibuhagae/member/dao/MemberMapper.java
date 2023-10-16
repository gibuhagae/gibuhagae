package com.gibuhagae.gibuhagae.member.dao;

import com.gibuhagae.gibuhagae.common.paging.SelectCriteria;
import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {


    int selectTotalCount(Map<String, String> searchMap);


    List<MemberDTO> selectMemberList(SelectCriteria selectCriteria);

    MemberDTO findByUserId(String memberId);

    int insertMember(MemberDTO memberDTO);

    String selectMemberByUserId(String userId);

    int deleteMember(Long no);

    int modifyMember(MemberDTO member);
}
