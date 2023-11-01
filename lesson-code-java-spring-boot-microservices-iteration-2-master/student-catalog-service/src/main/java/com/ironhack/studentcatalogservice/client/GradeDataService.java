package com.ironhack.studentcatalogservice.client;

import com.ironhack.moviecatalogservice.model.Grade;
import com.ironhack.moviecatalogservice.model.Course;
import com.ironhack.moviecatalogservice.model.CourseCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient("grade-data-service")
public interface gradeDataService {


    @GetMapping("/api/courses/{courseCode}/grades")
    CourseGrade getCourseGrades(@PathVariable String courseCode)

    @GetMapping("/api/courses/{courseCode}")
    Course getCourseById(@PathVariable String courseCode)
}
