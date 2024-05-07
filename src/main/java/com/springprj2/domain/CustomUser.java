package com.springprj2.domain;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Getter
// User 클래스를 상속하는 CustomUser 클래스 정의 = 사용자 정보를 효과적으로 관리
public class CustomUser extends User {
    private Member member;

    public CustomUser(Member member) {
        super(member.getEmail(),
                member.getPassword(),
                member.getAuthority().stream()
                        // 권한을 목록으로 가져와 SimpleGrantedAuthority 객체로 변환
                        .map(SimpleGrantedAuthority::new)
                        // 후 다시 리스트 변환
                        .toList()
        );
        this.member = member;
    }
}
