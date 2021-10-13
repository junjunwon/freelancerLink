package com.freelancerLink.config.auth.dto;

import com.freelancerLink.domain.user.UserInfo;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    /**
     * SessionUser에는 인증된 사용자 정보만 필요하다.
     * 그러면 여기서 의문점!
     * -> 왜 UerInfo 클래스를 사용하지 않았는가?
     * UserInfo를 그대로 사용하면 아래와 같은 에러가 발생한다.
     * "Failed to convert from type [java.lang.Object] to type[byte[]] for value 'UserInfo'
     * 이는 세션에 저장하기 위해 UserInfo 클래스를 세션에 저장하려고 하니 UserInfo 클래스에 직렬화를 구현하지 않았다.
     * 오류를 해결하기 위해 UserInfo에 직렬화 코드를 넣어도 되지만, 문제가 발생할 수 있다. 왜? UserInfo클래스는 엔티티이기 때문이다.
     * 엔티티 클래스는 언제 다른엔티티와 관계가 형성될지 모른다. 자세한 내용은 188페이지 참고.
     */
    private String name;
    private String email;
    private String picture;

    public SessionUser(UserInfo user){
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
