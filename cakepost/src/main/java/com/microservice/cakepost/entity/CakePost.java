package com.microservice.cakepost.entity;

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
@Table(name = "cakeposts")
public class CakePost {

    @Id
    private String id;
    private String title;
    private String content;
    private String description;
}
