package com.learnzo.student_management.repository;

import com.learnzo.student_management.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    default Student findByUserName(String username) {
        return null;
    }
}
