package com.example.objectMapperExample.service;

import com.example.objectMapperExample.domain.PostList;
import com.example.objectMapperExample.domain.Posts;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectMapperService {
    private String pathJsonUri="https://jsonplaceholder.typicode.com/posts";

    @Autowired
    RestTemplate restTemplate;

    @PostConstruct
    public void parsingJsonWithHttpClient() throws IOException, InterruptedException {
        HttpClient client= HttpClient.newHttpClient();
        HttpRequest request= HttpRequest.newBuilder().uri(URI.create(pathJsonUri)).build();
        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
        ObjectMapper mapper=new ObjectMapper();
        List<Posts> postsList=mapper.readValue(response.body(), new TypeReference<List<Posts>>(){});
        postsList.forEach(System.out::println);
    }

    public List<Posts> getPostsFromApi(){
        Posts [] posts= restTemplate.getForObject(pathJsonUri, Posts[].class);
        int length=posts.length;
        List<Posts> postsList= Arrays.stream(posts).collect(Collectors.toList());
        return postsList;}

        public List<Posts> getPostUsingWrapper(){
        PostList postList= restTemplate.getForObject(pathJsonUri, PostList.class);

        List<Posts> postsList=postList.getPostsList();
        return postsList;
        }
}
