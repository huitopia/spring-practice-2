package com.springprj2.service;

import com.springprj2.domain.Member;
import com.springprj2.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;
    private final BCryptPasswordEncoder encoder;

    public void insertMember(Member member) {
        member.setPassword(
                //BCryptPasswordEncoder 사용하여 비밀번호 해싱 과정
                encoder.encode(member.getPassword())
        );
        mapper.insertMember(member);
    }

    public String selectByEmail(String email) {
        String value = mapper.selectByEmail(email);
        if (value == null) {
            return "Not Use Email";
        } else {
            return "Use Email";
        }
    }
}
