//package com.freelancerLink.security;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//      //현재 security 관련 implement는 전부 제거했다. -> test시 403 접근제한이 발생 (추후에 시큐리티를 넣으면 어떻게 test할지에 대해 고민해야 할듯.
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.httpBasic().disable();
//    }
//}
