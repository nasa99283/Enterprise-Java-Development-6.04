package com.ironhack.studentcatalogservice.service.impl;

import com.ironhack.studentcatalogservice.client.StudentInfoService;
import com.ironhack.studentcatalogservice.client.GradeDataService;
import com.ironhack.studentcatalogservice.model.*;
import com.ironhack.studentcatalogservice.service.interfaces.CatalogServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CatalogService implements CatalogServiceInterface {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private gradesDataService gradesDataService;

    public Catalog getCatalog(int userId) {
        Course course = gradeDataService.getCourseById(courseCode);
        CourseGrade courseGrade=  gradeDataService.getCourseGrades(courseCode);
        String port = studentInfoService.getStudentInfo();
        log.info("Student Service Running in port - " + port);
        Catalog catalog = new Catalog();
        catalog.setcourseName(Course.getcourseName());
        List<Grade> getgrade = new ArrayList<>();

        //Loop over all user ratings and get the movie information for each rating
        for (Grade grade: courseGrade.getgrades()) {
            Student student = studentInfoService.getStudentInfo(rating.getStudentId());
            movieRatings.add(new MovieRating(movie.getName(), movie.getDescription(), rating.getRating()));
        }

        catalog.setMStudentGrade(studentsgrades);
        return catalog;
    }
}
