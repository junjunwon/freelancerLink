package com.freelancerLink.domain.post;

import com.freelancerLink.domain.post.Posts;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    /**
     * JpaRepository : DB Layer 접근자.
     * JpaRepository<Entity class, PK tyle>를  상속하면 기본적인 CRUD 메소드가 자동 생성된다.
     * @Repository를 추가할 필요도 없다.
     *   - 주의할점은 Entitiy 클래스와 기본 Entity Repository는 함께 위치해야하는 점!
     *   - Entity 클래스는 기본 Repository 없이는 제대로 역할을 할 수 없다.
     *   - 프로젝트 규모가 커져 도메인 별로 프로젝트를 분리해야할 때 Entity class와 기본 Repository는 함께 움직여야 해서 도메인 패키지에서 함께 관리한다.
     *
     *   SpringDataJpa에서 제공하지 않는 메소드는 쿼리로 작성해도 된다.
     */
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();


}
