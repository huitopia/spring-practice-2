package com.springprj2.service;

import com.springprj2.domain.CustomUser;
import com.springprj2.domain.Member;
import com.springprj2.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Member member = mapper.selectByEmail(email);
        if (member == null) {
            return "Available Email";
        } else {
            return "Unavailable Email";
        }
    }

    public List<Member> selectMember() {
        return mapper.selectMember();
    }

    public Member selectById(Integer id) {
        return mapper.selectById(id);
    }

    public void modifyMemberById(Member member) {
        if (member.getPassword() != null & member.getPassword().length() > 0) {
            // 암호를 입력했을 때만 변경
            member.setPassword(encoder.encode(member.getPassword()));
        } else {
            // 기존 암호 유지
            Member old = mapper.selectById(member.getId());
            member.setPassword(old.getPassword());
        }
        mapper.modifyMemberById(member);
    }

    public boolean hasAccess(Integer id, Authentication authentication) {
        if (authentication == null) { // 인증정보 없는 멤버
            return false;
        }
        // Authentication 객체에서 현재 사용자 정보를 가져오는 메서드
        Object principal = authentication.getPrincipal();
        // 사용자가 CustomUser 클래스의 인스턴스인지 확인
        if (principal instanceof CustomUser user) {
            // 해당 사용자의 회원 정보를 가져와서 Member 객체로 캐스팅 -> 사용자 정보 접근
            Member member = user.getMember();
            // member.Id 와 현재 사용자의 id가 일치하는지
            //  동일하면 true, 다르면 false 리턴
            return member.getId().equals(member.getId());
        }
        return false;
    }
}
