package com.microservice.cakecomment.service;

import com.microservice.cakecomment.config.RestTemplateConfig;
import com.microservice.cakecomment.entity.CakeComment;
import com.microservice.cakecomment.payload.CakePost;
import com.microservice.cakecomment.repository.CakeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CakeCommentService {

    @Autowired
    private CakeCommentRepository cakeCommentRepository;
    @Autowired
    private RestTemplateConfig restTemplateConfig;
    public CakeComment saveCakeComment(CakeComment cakeComment){
        CakePost cakePost = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8081/api/cake/" +
                cakeComment.getCakePostId(), CakePost.class);

        if(cakePost!=null){
            String commentId = UUID.randomUUID().toString();
            cakeComment.setCakeCommentId(commentId);
            CakeComment savedComment = cakeCommentRepository.save(cakeComment);
            return savedComment;
        }else {
            return null;
        }
    }

    public List<CakeComment> getAllCommentsByPostId(String postId){
       List <CakeComment> comments = cakeCommentRepository.findByCakePostId(postId);
        return comments;
    }
}
