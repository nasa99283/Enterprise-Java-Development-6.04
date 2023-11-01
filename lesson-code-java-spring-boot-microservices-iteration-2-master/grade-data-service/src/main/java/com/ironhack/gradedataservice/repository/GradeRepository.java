package com.ironhack.gradedataservice.repository;


import com.ironhack.gradedataservice.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface GradeRepository extends JpaRepository<Grade,Integer> {
    List<Grade> findByGradeId(String gradeId);
}
