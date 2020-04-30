package com.example.objectMapperExample.controller;

import com.example.objectMapperExample.domain.Posts;
import com.example.objectMapperExample.service.ObjectMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ObjectController {
    @Autowired
    ObjectMapperService objectMapperService;
/*
    @GetMapping("/posts")
    public List<Posts> getPostsLists(){
        return objectMapperService.getPostsFromApi();
    }

 */


    @GetMapping("/posts")
    public List<Posts> getPostsLists(){
        return objectMapperService.getPostUsingWrapper();
    }

}
