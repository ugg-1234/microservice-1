package com.microservice.cakepost.repository;

import com.microservice.cakepost.entity.CakePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakePostRepository extends JpaRepository<CakePost,String> {

}
