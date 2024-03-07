package com.sp.survey.service;

import com.sp.survey.domain.Member;
import com.sp.survey.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Override
    public void register(Member dto) throws Exception {

        mapper.insertMember(dto);
    }
}
