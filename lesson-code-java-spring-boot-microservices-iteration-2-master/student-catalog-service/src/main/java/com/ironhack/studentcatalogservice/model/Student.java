package com.ironhack.studentcatalogservice.model;

public class Student {

    String studentName;
    String studentId;
    private String grade;


    public Student(String studentName, String studentId, String grade) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.grade = grade;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}