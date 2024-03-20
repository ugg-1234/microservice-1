package com.microservice.cakepost.controller;

import com.microservice.cakepost.entity.CakePost;
import com.microservice.cakepost.payload.CakePostDto;
import com.microservice.cakepost.service.CakePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cake")
public class CakePostController {

    @Autowired
    private CakePostService cakePostService;
    @PostMapping
    public ResponseEntity<CakePost> saveCakePost(@RequestBody CakePost cakePost){
        CakePost post = cakePostService.saveCakePost(cakePost);
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }
    @GetMapping("/{postId}")
    public CakePost getCakePostByPostId(@PathVariable String postId){
        CakePost cakePost = cakePostService.findCakePostById(postId);
        return cakePost;
    }
    @GetMapping("/{postId}/comments")
    public ResponseEntity<CakePostDto> getCakePostWithComments(@PathVariable String postId){
        CakePostDto cakePostDto = cakePostService.getCakePostWithComments(postId);
        return new ResponseEntity<>(cakePostDto,HttpStatus.OK);
    }


}
