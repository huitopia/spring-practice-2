package com.springprj2.controller;

import com.springprj2.domain.Member;
import com.springprj2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

        return "redirect:/member/login";
    }

    @GetMapping("email")
    @ResponseBody
    public String emailCheck(String email) {
        String message = service.selectByEmail(email);
        return message;
    }

    @GetMapping("login")
    public String loginForm() {
        return "member/login";
    }

    @GetMapping("")
    public String memberList(Model model) {
        List<Member> member = service.selectMember();
        model.addAttribute("memberList", member);
        return "member/list";
    }
}
