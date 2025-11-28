package com.back.SpringValidationTest_1.domain.post.post.controller;

import com.back.SpringValidationTest_1.domain.post.post.entity.Post;
import com.back.SpringValidationTest_1.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts/write")
    @ResponseBody
    public String showWrite(){
        return """
                <form action="http://localhost:8080/posts/doWrite" method="POST">
                                  <input type="text" name="title" placeholder="제목" value="안녕">
                                  <br>
                                  <textarea name="content" placeholder="내용">반가워.</textarea>
                                  <br>
                                  <input type="submit" value="작성">
                                </form>
                """;
    }
    @PostMapping("/posts/doWrite")
    @ResponseBody
    @Transactional
    public String doWrite(@RequestParam("title") String title,
                          @RequestParam(value = "content") String content){
        return postService.save(new Post(title,content)).toString();
    }
}
