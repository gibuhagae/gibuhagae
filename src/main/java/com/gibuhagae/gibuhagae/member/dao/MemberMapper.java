package com.gibuhagae.gibuhagae.member.dao;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    MemberDTO findMemberById(String memberId);

    List<MemberDTO> selectFindIdInfos(String mName, String mEmail);

    MemberDTO selectFindPwdInfos(String mId, String mName, String mEmail);

    int registMember(MemberDTO member);

    String selectMemberId(String userId);

    int modifyMemberPwdById(String userId, String password);

    int deleteMember(String memberId);

    int modifyMemberInfo(MemberDTO member);
}
