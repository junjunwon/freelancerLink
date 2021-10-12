package com.freelancerLink.domain.user;

import com.freelancerLink.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserInfo extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 100, nullable = false)
    private String password;

    @Builder
    public UserInfo(String userId, String password){
        this.userId = userId;
        this.password = password;
    }
}
