package com.test.user.controller;

import com.test.user.pojo.PostDTO;
import com.test.user.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDTO> getPosts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            throw new IllegalArgumentException("Page and size parameters must be greater than zero.");
        }

        List<PostDTO> allPosts = postService.getAllPosts();
        return allPosts.stream()
                .skip(page * size)
                .limit(size)
                .collect(Collectors.toList());
    }
}
