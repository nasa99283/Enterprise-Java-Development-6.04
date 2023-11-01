package com.ironhack.studentcatalogservice.controller;
import com.ironhack.studentcatalogservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/catalogs/Course/{courseCode}")
    @ResponseStatus(HttpStatus.OK)
    public Catalog getCatalog(@PathVariable String courseCode) {


        CourseGrade courseGrade = restTemplate.getForObject("http://localhost:8083/api/courses/" + courseCode + "/rgrades", CourseGrade.class);

        Catalog catalog = new Catalog();
        catalog.setCourseName(courseGrade.getCourseCode());
        List<StudentGrade> studentGrades = new ArrayList<>();

        // Loop over all user ratings and get the movie information for each rating
        for (Grade grade : courseGrade.getGrades()) {
            Student student = restTemplate.getForObject("http://localhost:8082/api/studentss/" + grade.getGrade(), Student.class);
            studentGrades.add(new StudentGrade(student.getStudentName(), student.getStudentId(), grade.getGrade()));
        }
        catalog.setStudentGrades(studentGrades);

        return catalog;
    }
}
