package com.ironhack.studentinfoservice.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Student {

    @Id
    private Long studentId;
    private String name;
    private int age;

    public Student(Long studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}