package com.microservice.cakecomment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cakecomment")
public class CakeComment {

    @Id
    private  String cakeCommentId;
    private String name;
    private String email;
    private String body;
    private String cakePostId;
}
