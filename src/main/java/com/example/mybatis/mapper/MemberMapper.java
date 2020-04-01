package com.example.mybatis.mapper;

import com.example.mybatis.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    String loginCheck(@Param("loginId") String loginId);
    int isSameCheckLoginId(String loginId);
    void memberRegister(Member member);
    String passwordFind(String loginId, String name);
}
