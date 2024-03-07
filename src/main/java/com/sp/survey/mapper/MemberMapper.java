package com.sp.survey.mapper;

import com.sp.survey.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MemberMapper {

    public void insertMember(Member dto) throws SQLException;
}
