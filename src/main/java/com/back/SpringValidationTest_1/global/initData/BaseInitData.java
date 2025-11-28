package com.back.SpringValidationTest_1.global.initData;

import com.back.SpringValidationTest_1.domain.post.post.entity.Post;
import com.back.SpringValidationTest_1.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BaseInitData {
    private final PostService postService;
    @Bean
    ApplicationRunner applicationRunner (){
        return (rs)->{
            if(postService.count()>0) return;
            Post post1 = postService.write("제목1","내용1");
            Post post2 = postService.write("제목2","내용2");
            Post post3 = postService.write("제목3","내용3");


        };
    }
}
