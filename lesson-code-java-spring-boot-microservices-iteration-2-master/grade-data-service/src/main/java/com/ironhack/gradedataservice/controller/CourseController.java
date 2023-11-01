package com.ironhack.gradedataservice.controller;

import com.ironhack.gradedataservice.DTO.CourseGrade;
import com.ironhack.gradedataservice.model.Course;
import com.ironhack.gradedataservice.repository.CourseRepository;
import com.ironhack.gradedataservice.service.interfaces.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class CourseController {

    @Autowired
    CourseServiceInterface courseService;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses/{courseCode}")  // Corrected the path variable name to courseCode
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseById(@PathVariable String courseCode) {
        return courseRepository.findById(courseCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }

    @GetMapping("/courses/{courseCode}/grades")  // Corrected the path variable name to courseCode
    @ResponseStatus(HttpStatus.OK)
    public CourseGrade getCourseGrades(@PathVariable String courseCode) {
        return courseService.getCourseGrade(courseCode);  // Corrected the method name to getCourseGrade
    }
}
