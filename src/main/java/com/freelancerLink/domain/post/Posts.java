package com.freelancerLink.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {
    /**
     * Request/Response 클래스로 사용해서는 안된다.
     * Entity 클래스는 DB와 맞닿은 핵심 클래스로 테이블이 생성되고 스키마가 변경된다.
     * View Layer와 DB Layer의 역할 분리를 철저히!
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함됌.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    /**
     * setter의 무작정 생성 제한
     * 차후 기능 변경 시 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확히 구분할 수가 없다.
     * Entity 클래스에서는 절대 Setter 메소드 생성 X -> 대신, 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가한다.
     * public void cancelPost(){
     *     this.status = false;
     * }
     */
}
