package com.freelancerLink.config.auth;


import com.freelancerLink.config.auth.dto.OAuthAttributes;
import com.freelancerLink.config.auth.dto.SessionUser;
import com.freelancerLink.domain.user.UserInfo;
import com.freelancerLink.domain.user.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    /**
     * (1)
     * - 현재 로그인 진행 중인 서비스를 구분하는 코드
     * - 지금은 구글만 사용하는 불필요한 값이지만 이후 넨이버 로그인 연동 시에 네이버 로그인인지 구글 로그인인지 구분하기 위해 사용한다.
     *
     * (2) userNameAttributeName
     * - OAuth2 로그인 진행 시 키가 되는 필드값을 이야기한다. Primary Key와 같은 의미
     * - 구글의 경우 기본적으로 코드를 지원하지만 네이버 카카오 등은 기본 지원하지 않습니다. 구글의 기본 코드는 "sub"이다.
     * - 이후 네이버 로그인과 구글 로그인을 동시 지원할 때 사용된다.
     *
     * (3) SessionUser
     * - 세션에 사용자 정보를 저장하기 위한 Dto클래스.
     *
     */


    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest
                .getClientRegistration().getRegistrationId();

        String userNameAttributeName = userRequest // (1)
                .getClientRegistration().getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();

        OAuthAttributes attributes = OAuthAttributes
                .of(registrationId, userNameAttributeName, //(2)
                        oAuth2User.getAttributes());

        UserInfo user = saveOrUpdate(attributes);

        httpSession.setAttribute("user", new SessionUser(user)); //(3) SessionUser

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());

    }

    private UserInfo saveOrUpdate(OAuthAttributes attributes){
        UserInfo user = userRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes
                        .getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());

        return userRepository.save(user);
    }
}
