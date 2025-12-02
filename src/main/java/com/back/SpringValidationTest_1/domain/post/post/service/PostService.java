package com.back.SpringValidationTest_1.domain.post.post.service;

import com.back.SpringValidationTest_1.domain.post.post.entity.Post;
import com.back.SpringValidationTest_1.domain.post.post.repository.PostRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    public Post write(String title, String content) {
        Post post = new Post(title, content);
        return postRepository.save(post);
    }

    public long count() {
        return postRepository.count();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public void modify(Post post,  String title, String content) {
        post.setContent(content);
        post.setTitle(title);
        postRepository.save(post);
    }
}
