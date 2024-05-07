package com.springprj2.service;

import com.springprj2.domain.CustomUser;
import com.springprj2.domain.Member;
import com.springprj2.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
// Spring Security 인증 작업 수행
public class CustomUserDetailsService implements UserDetailsService {
    // 사용자 정보 DB 에서 가져오기 위함
    private final MemberMapper mapper;

    @Override
    // 주어진 email 기반으로 사용자 정보 가져온 후 UserDetails 객체로 반환
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // 이메일에 해당하는 사용자 정보 DB 조회
        Member member = mapper.selectByEmail(username);
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        // 사용자의 권한 DB 조회
        List<String> authority = mapper.selectAuthorityByMemberId(member.getId());
        System.out.println("authority = " + authority);
        // 사용자 객체에 조회된 권한 설정
        member.setAuthority(authority);
        return new CustomUser(member);
    }
}
