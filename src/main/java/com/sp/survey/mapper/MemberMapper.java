package com.sp.survey.mapper;

import com.sp.survey.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MemberMapper {

    public void insertMember(Member dto) throws SQLException;
    public Integer loginByCount(Member dto) throws SQLException;

    public String findById(String id) throws SQLException;
}
