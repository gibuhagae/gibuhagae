package com.gibuhagae.gibuhagae.member.dao;

import com.gibuhagae.gibuhagae.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberDTO findMemberById(String memberId);

    int registMember(MemberDTO member);
}
