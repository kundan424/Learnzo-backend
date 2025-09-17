package com.learnzo.student_management.service;

import com.learnzo.student_management.entity.Student;
import com.learnzo.student_management.exception.ResourceNotFoundException;
import com.learnzo.student_management.repository.StudentRepository;
import com.mongodb.DuplicateKeyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student addStudent (Student student){
        try {
            return  studentRepository.save(student);
        }catch (DuplicateKeyException e) {
            throw new RuntimeException("A student with the email '" + student.getEmail() + "'already exists.");
        }
    }

    public void deleteStudent (String id){
        // check if student with given ID exists in the database
        if (!studentRepository.existsById(id)){
            throw  new ResourceNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }

    /**
     * Update a student's course by their ID
     * @param id The ID of the student to update
     * @param newCourse The new course name
     * @return the updated student
     */

    public Student updateStudentCourse (String id, String newCourse){
        Optional<Student> studentInDb = studentRepository.findById(id);
        if (studentInDb.isPresent()){
            Student studentToUpdate = studentInDb.get();
            studentToUpdate.setCourse(newCourse);
            // save student with updated course in database
            return studentRepository.save(studentToUpdate);
        }else {
            throw new RuntimeException("Student not found with id:" + id);
        }
    }
}
