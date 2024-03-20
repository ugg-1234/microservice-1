package com.microservice.cakepost.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakeComment {

    private  String cakeCommentId;
    private String name;
    private String email;
    private String body;
    private String cakePostId;
}
