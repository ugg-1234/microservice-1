package com.microservice.cakecomment.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakePost {
    private String postId;
    private String title;
    private String content;
    private String description;
}
