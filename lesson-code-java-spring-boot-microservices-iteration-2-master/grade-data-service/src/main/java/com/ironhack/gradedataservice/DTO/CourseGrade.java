package com.ironhack.gradedataservice.DTO;


import com.ironhack.gradedataservice.model.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseGrade {
    private String courseCode;
    private List<Grade> grades;

    public CourseGrade(String courseCode, List<Grade> grades) {
        this.courseCode = courseCode;
        this.grades = grades;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }
}
