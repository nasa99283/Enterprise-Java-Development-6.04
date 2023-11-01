package com.ironhack.studentinfoservice;

import com.ironhack.studentinfoservice.model.Student;
import com.ironhack.studentinfoservice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class StudentInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentInfoServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository studentRepository) {
        return args -> {

            studentRepository.save(new Student(1L, "Nada", 20));
            studentRepository.save(new Student(2L, "Muna", 22));

        };
    }

}
