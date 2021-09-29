package com.freelancerLink.service.posts;

import com.freelancerLink.domain.post.Posts;
import com.freelancerLink.domain.post.PostsRepository;
import com.freelancerLink.web.dto.PostsResponseDto;
import com.freelancerLink.web.dto.PostsSaveRequestDto;
import com.freelancerLink.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    /**
     * Autowired가 없는 이유는? 생성자로 주입받기 때문.
     * 생성자로 Bean 객체를 주입받도록 하면 @Autowired와 동일한 효과
     * @ReuqiredArgsConstructor로 final로 선언된 모든 필드를 인자값으로 하는 생성자를 롬복에서 생성.
     * 생성자 대신 사용하는 이유는 의존성 관계가 변경될때마다 생성자 코드를 계속 수정해야하는 번거로움때문.
     */
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}
