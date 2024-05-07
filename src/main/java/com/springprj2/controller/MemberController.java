package com.springprj2.controller;

import com.springprj2.domain.Member;
import com.springprj2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("member")
public class MemberController {
    private final MemberService service;

    @GetMapping("signup")
    public String sighUpForm() {
        return "member/signup";
    }

    @PostMapping("signup")
    public String signUp(Member member) {
        service.insertMember(member);
        return null;
    }

    @GetMapping("email")
    @ResponseBody
    public String emailCheck(String email) {
        String message = service.selectByEmail(email);
        return message;
    }
}
