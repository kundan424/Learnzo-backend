package com.learnzo.student_management.repository;

import com.learnzo.student_management.entity.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppUserRepository extends MongoRepository<AppUser, String> {

    AppUser findByUsername(String username);
}
