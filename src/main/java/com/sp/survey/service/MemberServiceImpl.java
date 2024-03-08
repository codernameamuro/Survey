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

    @Override
    public Boolean login(Member dto) throws Exception {
        if(mapper.loginByCount(dto) ==1 ){
            return true;
        } else {
            return  false;
        }

    }

    @Override
    public String findById(String id) throws Exception {
        String password = null;
        password = mapper.findById(id);

        return password;
    }

    @Override
    public String findEmail(String id) throws Exception {

        String email = mapper.findEmail(id);

        return email;
    }
}
