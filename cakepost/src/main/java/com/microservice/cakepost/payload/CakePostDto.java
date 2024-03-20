package com.microservice.cakepost.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CakePostDto {
    private String id;
    private String title;
    private String content;
    private String description;

    List<CakeComment> cakeComments;
}
