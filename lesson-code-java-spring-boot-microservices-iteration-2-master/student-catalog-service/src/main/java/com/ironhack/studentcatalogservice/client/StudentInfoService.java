package com.ironhack.moviecatalogservice.client;

import com.ironhack.moviecatalogservice.model.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("student-info-service")
public interface StudentInfoService {
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id)
}
