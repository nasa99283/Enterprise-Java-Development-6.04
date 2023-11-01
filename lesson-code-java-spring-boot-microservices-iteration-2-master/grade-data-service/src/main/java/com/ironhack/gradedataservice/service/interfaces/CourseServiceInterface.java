package com.ironhack.gradedataservice.service.interfaces;

import com.ironhack.gradedataservice.DTO.CourseGrade;

public interface CourseServiceInterface {

    CourseGrade getCourseGrade(String courseCode);

    void addGradeToCourse(String courseCode, Integer gradeId);
}
