package com.ironhack.gradedataservice;

import com.ironhack.gradedataservice.model.Course;

import com.ironhack.gradedataservice.model.Grade;

import com.ironhack.gradedataservice.repository.CourseRepository;
import com.ironhack.gradedataservice.service.impl.CourseServiceImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
@EnableEurekaClient

public class gradesDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(gradesDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner run(CourseRepository courseRepository, CourseServiceImp courseService) {
		return args -> {

			courseRepository.save(new Course("A123", "Math", new ArrayList<>()));
			courseRepository.save(new Course("A193", "Science", List.of(new Grade("3",4,6))));

			courseService.addGradeToCourse("Am1", 1);
			courseService.addGradeToCourse("E21", 2);
		};
	}
}
