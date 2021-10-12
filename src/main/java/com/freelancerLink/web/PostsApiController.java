package com.freelancerLink.web;

import com.freelancerLink.service.posts.PostsService;
import com.freelancerLink.web.dto.PostsResponseDto;
import com.freelancerLink.web.dto.PostsSaveRequestDto;
import com.freelancerLink.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long updated(@PathVariable Long id,
                       @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){

        return postsService.findById(id);
    }

}
