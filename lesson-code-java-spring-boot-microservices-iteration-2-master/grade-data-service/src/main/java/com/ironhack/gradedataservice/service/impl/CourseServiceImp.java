package com.ironhack.gradedataservice.service.impl;

import com.ironhack.gradedataservice.DTO.CourseGrade;
import com.ironhack.gradedataservice.model.Course;
import com.ironhack.gradedataservice.model.Grade;
import com.ironhack.gradedataservice.repository.GradeRepository;
import com.ironhack.gradedataservice.repository.CourseRepository;
import com.ironhack.gradedataservice.service.interfaces.CourseServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseServiceInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public CourseGrade getCourseGrade(String courseCode) {
        Optional<Course> courseFromDb = courseRepository.findById(courseCode);
        if (courseFromDb.isPresent()) {
            List<Grade> courseGrades = courseFromDb.get().getGrades();
            return new CourseGrade(courseCode, courseGrades);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
        }
    }

    public void addGradeToCourse(String courseCode, Integer gradeId) {
        Course course = courseRepository.findById(courseCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
        Grade grade = gradeRepository.findById(gradeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Grade not found"));
        course.getGrades().add(grade);
        courseRepository.save(course);
    }
}
