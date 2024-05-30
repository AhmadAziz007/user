package com.test.user.service;

import com.test.user.pojo.PostDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private static final String URL = "https://jsonplaceholder.typicode.com/posts";

    public List<PostDTO> getAllPosts() {
        RestTemplate restTemplate = new RestTemplate();
        PostDTO[] posts = restTemplate.getForObject(URL, PostDTO[].class);
        return Arrays.asList(posts);
    }
}
