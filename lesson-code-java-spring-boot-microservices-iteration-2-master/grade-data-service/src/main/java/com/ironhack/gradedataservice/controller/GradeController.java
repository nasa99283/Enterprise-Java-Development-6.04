package com.ironhack.gradedataservice.controller;

import com.ironhack.gradedataservice.model.Grade;

import com.ironhack.gradedataservice.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/grade")
public class GradeController {

    @Autowired
    GradeRepository gradeRepository;

    @GetMapping("/grades")
    @ResponseStatus(HttpStatus.OK)
    public List<Grade> getgrade(@RequestParam Optional<String> gradeId) {
        if (gradeId.isPresent()) {
            return gradeRepository.findByGradeId(gradeId.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong grade  id")));
        }
        return gradeRepository.findAll();

    }}