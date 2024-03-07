package com.sp.survey.controller;

import com.sp.survey.domain.Member;
import com.sp.survey.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private MemberService service;

    @RequestMapping (value = "/main", method = RequestMethod.GET)
    public String homepage(){
        return "home/main";
    }

    @GetMapping("/member/member")
    public String memberForm(){
        return "member/register";
    }

    @PostMapping("/member/register")
    public String memberRegister(@RequestBody Member dto) throws Exception {
        System.out.println(dto.getEmail());
        System.out.println(dto.getId());
        System.out.println(dto.getPassword());

        service.register(dto);
        return "home/main";
    }

}
