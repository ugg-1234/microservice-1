package com.microservice.cakecomment.controller;

import com.microservice.cakecomment.entity.CakeComment;
import com.microservice.cakecomment.service.CakeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cakecomments")
public class CakeCommentController {
    @Autowired
    private CakeCommentService cakeCommentService;
    @PostMapping
    public ResponseEntity<CakeComment> saveCakeComment(@RequestBody CakeComment cakeComment){
        CakeComment c = cakeCommentService.saveCakeComment(cakeComment);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public List<CakeComment> getAllCommentsByPostId(@PathVariable String postId){
        List<CakeComment> cakeComments = cakeCommentService.getAllCommentsByPostId(postId);
        return cakeComments;
    }

}
