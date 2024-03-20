package com.microservice.cakepost.service;

import com.microservice.cakepost.config.RestTemplateConfig;
import com.microservice.cakepost.entity.CakePost;
import com.microservice.cakepost.payload.CakeComment;
import com.microservice.cakepost.payload.CakePostDto;
import com.microservice.cakepost.repository.CakePostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class CakePostService {

    @Autowired
    private CakePostRepository cakePostRepository;

    @Autowired
    private RestTemplateConfig restTemplateConfig;
    public CakePost saveCakePost(CakePost cakePost){
        String cakePostId = UUID.randomUUID().toString();
        cakePost.setId(cakePostId);

        CakePost savedCakePost = cakePostRepository.save(cakePost);
        return savedCakePost;
    }
    public CakePost findCakePostById (String postId){
        CakePost post = cakePostRepository.findById(postId).get();
        return post;
    }
    public CakePostDto getCakePostWithComments(@PathVariable String postId){
        ArrayList comments = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8082/api/cakecomments/" + postId, ArrayList.class);
        CakePost post = cakePostRepository.findById(postId).get();
        
        CakePostDto cakePostDto = new CakePostDto();
        cakePostDto.setId(post.getId());
        cakePostDto.setContent(post.getContent());
        cakePostDto.setTitle(post.getTitle());
        cakePostDto.setCakeComments(comments);
        return cakePostDto;
    }
}
