package com.freelancerLink.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    /**
     * 해당 클래스는 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할을 수행한다.
     * @MappedSuperclass
     * - JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록 한다.
     * @EntityListeners(AuditingEntityListener.class)
     * - BaseTimeEntity클래스에 Auditing 기능을 포함시킨다.
     *
     * 해당 클래스를 활성화하기 위해 Application.class에 @EnableJpaAuditing 추가.
     */
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
