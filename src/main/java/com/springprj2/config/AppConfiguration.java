package com.springprj2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Bean 구성을 정의
@EnableMethodSecurity // Spring Security에서 메소드 수준의 보안을 활성화하는 데 사용
public class AppConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        // Spring Security에서 CSRF(Cross-Site Request Forgery) 보호를 비활성
        http.csrf(csrf -> csrf.disable());
        // 사용자가 로그인할 때 사용될 사용자 지정 로그인 페이지를 설정
        http.formLogin(login -> login.loginPage("/member/login"));
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
