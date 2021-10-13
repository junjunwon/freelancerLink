package com.freelancerLink.web;

import com.freelancerLink.config.ApiResult;
import com.freelancerLink.config.auth.dto.SessionUser;
import com.freelancerLink.domain.post.Posts;
import com.freelancerLink.service.posts.PostsService;
import com.freelancerLink.web.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class IndexController {
    /**
     * 페이지에 관련된 컨트롤러는 모두 IndexController를 사용!
     * @return
     */

    private final PostsService postsService; //final 초기값이 정해지면 최종적인 값이 되어 프로그램 실행 도중에 수정할 수 없다.
    private final HttpSession httpSession;
    @GetMapping("/board/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("board/list")
    public ApiResult<List<PostsListResponseDto>> getAll(){
        List<PostsListResponseDto> list = postsService.findAllDesc();
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return ApiResult.<List<PostsListResponseDto>>builder()
                .data(list)
                .build();
    }



}
