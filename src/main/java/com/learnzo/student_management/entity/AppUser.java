package com.learnzo.student_management.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class AppUser {

    @Id
    private String id;
    private String username;
    private String password;
    private String roles;
}
