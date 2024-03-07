package com.sp.survey.controller;

import com.sp.survey.domain.Member;
import com.sp.survey.domain.SessionInfo;
import com.sp.survey.service.MemberService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private MemberService service;

    @RequestMapping (value = "/main", method = RequestMethod.GET)
    public String homepage(){
        return "home/main";
    }

    @GetMapping("/member")
    public String memberpage(){
        return "home/member";
    }

    @GetMapping("/member/member")
    public String memberForm(){
        return "member/register";
    }

    @GetMapping("/member/login")
    public String memberLogin(){
        return "member/login";
    }

    @PostMapping("/member/loginConfirm")
    public String memberLoginConfirm(@RequestParam String id, @RequestParam String password,
                                     Model model,
                                     HttpSession session) throws  Exception{
        Member dto = new Member();
        dto.setId(id);
        System.out.println(dto.getId());
        dto.setPassword(password);
        System.out.println(dto.getPassword());

        if (!dto.getPassword().equals(service.findById(dto.getId()))) {
            model.addAttribute("msg", "패스워드 또는 아이디가 일치하지 않습니다.");
            return "member/login";
        } else{
            service.login(dto);

        }

        SessionInfo info = new SessionInfo();
        info.setEmail(dto.getEmail());
        info.setId(dto.getId());
        info.setPassword(dto.getPassword());

        session.setAttribute("member", info);


        return "home/member";
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
