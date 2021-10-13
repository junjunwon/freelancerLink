package com.freelancerLink.config.auth;


import com.freelancerLink.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활설화해준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //여기까지 -> h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
                .and()
                    .authorizeRequests()//URL 별 권한 관리를 설정하는 옵션의 시작으로 authorizeRequests가 선언되어야만 antMatchers 옵션 시작 가능.
                    .antMatchers("/", "/css/**", "/images/**", //권한 관리 대상을 지정하는 옵션이다. URL, HTTP 메소드별로 관리가 가능하다. "'"등 지정된 URL들은 permitAll로 전체 열람 권한.
                            "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //"/api/v1/*"주소를 가진 API은 USER권한을 가진 사람만 가능하도록 지정.
                    .anyRequest().authenticated() //anyRequest() : 설정된 값들 이외 나머지 URL이고 authenticated()를 추가하여 나머지 URL들은 모두 인증된 사용자들에게만 허용된다.
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login() //OAuth2 로그인 기능에 대한 여러 설정의 진입점.
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
        //리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
    }
}
