package com.sp.survey.service;

import com.sp.survey.domain.Member;

public interface MemberService {
    public void register(Member dto) throws  Exception;
    public Boolean login(Member dto) throws  Exception;
    public String findById(String id) throws Exception;
}
