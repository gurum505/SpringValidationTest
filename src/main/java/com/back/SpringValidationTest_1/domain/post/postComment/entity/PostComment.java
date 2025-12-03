package com.back.SpringValidationTest_1.domain.post.postComment.entity;

import com.back.SpringValidationTest_1.domain.post.post.entity.Post;
import com.back.SpringValidationTest_1.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PostComment extends BaseEntity {
    @ManyToOne
    private Post post;

    private String content;

    public PostComment(Post post, String content) {
        this.post = post;
        this.content = content;
    }
}
