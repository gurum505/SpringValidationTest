package com.back.SpringValidationTest_1.domain.post.post.controller;

import com.back.SpringValidationTest_1.domain.post.post.entity.Post;
import com.back.SpringValidationTest_1.domain.post.post.service.PostService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    private String getWriteFormHtml() {
        return getWriteFormHtml("","","","");
    }

    private String getWriteFormHtml(String errorMessage,String title, String content,String errorFieldName) {
        return """
                <div style="color: red;">%s</div>
                
                <form method="POST" action="doWrite">
                  <input type="text" name="title" placeholder="제목" value="%s"autofocus>
                  <br>
                  <textarea name="content" placeholder="내용">%s</textarea>
                  <br>
                  <input type="submit" value="작성">
                </form>
                
                <script>
                const errorFieldName = '%s';
                if ( errorFieldName.length > 0 ){
                    const forms = document.querySelectorAll('form');
                    const lastForm = forms[forms.length - 1];
                    lastForm[errorFieldName].focus();
                }   
                </script>
                
                """.formatted(errorMessage,title,content,errorFieldName);
    }

    @GetMapping("/posts/write")
    @ResponseBody
    public String showWrite() {
        return getWriteFormHtml();
    }


    @AllArgsConstructor
    @Getter
    public static class WriteForm {
        @NotBlank
        @Size(min = 2, max = 20)
        private String title;
        @NotBlank
        @Size(min = 2, max = 20)
        private String content;
    }

    @PostMapping("/posts/doWrite")
    @ResponseBody
    @Transactional
    public String write(
            @Valid WriteForm form
    ) {
        Post post = postService.write(form.getTitle(),form.getContent());

        return "%d번 글이 생성되었습니다.".formatted(post.getId());
    }
}
