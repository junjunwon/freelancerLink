package com.freelancerLink.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    //참고 : https://dev-pengun.tistory.com/entry/Spring-Boot-CORS-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0
    //CORS 설정하기.
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") //CORS를 적용할 URL 패턴 정의 -> "/** 전체 패턴"
                .allowedOrigins("*") //자원 공유를 허락할 Origin 지정 ("*" 혹은 "http://localhost:3032" 로도 지정가능하다.)
                .allowedMethods("*"); //"GET", "POST"와 같이 허용할 HTTP method를 지정할 수 있다.
//                .maxAge(3000); //원하는 시간만큼 pre-flight 리퀘스트를 캐싱해둘 수 있다.

    }
}
