package com.example.objectMapperExample.domain;

import java.util.List;

public class PostList {
    private List<Posts> postsList;

    public PostList() {
    }

    public PostList(List<Posts> postsList) {
        this.postsList = postsList;
    }

    public List<Posts> getPostsList() {
        return postsList;
    }

    public void setPostsList(List<Posts> postsList) {
        this.postsList = postsList;
    }
}
