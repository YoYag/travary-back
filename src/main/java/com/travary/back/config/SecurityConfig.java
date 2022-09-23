package com.travary.back.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(authorize -> authorize
                        // 접근권한설정
                        .antMatchers("/user/**").authenticated() // 인증이 이루어진 경우
                        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                        .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                        .anyRequest().permitAll() // 인증이 이루어지지 않아도 모든 사용자가 접근
                )
                // 인증필터에 의해 로그인하지 않은 경우
                .formLogin()
                .usernameParameter("identifier")
                .loginPage("/sign_in") // 로그인 페이지로 이동
                .loginProcessingUrl("/login") // /login 주소가 호출되면 시큐리티가 낚아ㅐ서 대신 로그인을 진행
                .defaultSuccessUrl("/");
        return http.build();
    }
}