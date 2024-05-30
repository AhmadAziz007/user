package com.test.user.factory;

import com.test.user.pojo.PostDTO;

public class PostFactory {
    public static PostDTO createPost(int userId, String title) {
        PostDTO post = new PostDTO();
        post.setUserId(userId);
        post.setTitle(title);
        return post;
    }
}
