package com.ironhack.studentinfoservice.controller;

import com.ironhack.studentinfoservice.model.Student;
import com.ironhack.studentinfoservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Students")
public class StudentController {



    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        return studentOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

}
