package com.microservice.cakecomment.repository;

import com.microservice.cakecomment.entity.CakeComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CakeCommentRepository extends JpaRepository<CakeComment,String> {

    List<CakeComment> findByCakePostId(String postId);
}
