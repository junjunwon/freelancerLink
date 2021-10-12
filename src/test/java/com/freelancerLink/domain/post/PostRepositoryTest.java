package com.freelancerLink.domain.post;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After //
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_get_board(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("junho@gmail.com")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll(); //

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

    @Test
    public void BastTimeEntity() {
        //given
        /**
         * //LocalDate.now()로 테스트할 경우 날짜나 어떤 문제에 따라 성공할 때도 아닐때도 있다.
         * 그렇기 때문에 아래와 같이 테스트코드에서 날짜를 고정하자. (기억보단 기록을)
         */
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println("createDate = "+posts.getCreatedDate()+", modifiedDate = "+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now); //isAfter() 인자보다 미래일때 true가 리턴된다.
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
