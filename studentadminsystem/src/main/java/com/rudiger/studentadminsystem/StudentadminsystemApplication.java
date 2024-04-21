package com.rudiger.studentadminsystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rudiger.studentadminsystem.DTO.StudentRequestDTO;
import com.rudiger.studentadminsystem.service.StudentService;


@SpringBootApplication
public class StudentadminsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentadminsystemApplication.class, args);
		System.out.println("Spring boot application started");
	}

	@Bean
	CommandLineRunner start(StudentService studentService)
	{
		return args -> {
			studentService.saveStudent(new StudentRequestDTO("TEST1","FEUTSOP","DSCHANG-CITY"));
			studentService.saveStudent(new StudentRequestDTO("TEST2","FEUT","BAFOUSSAM-CITY"));
			studentService.saveStudent(new StudentRequestDTO("TEST3","FEUTSOP KENNE","BUEA-CITY"));
			studentService.saveStudent(new StudentRequestDTO("TEST4","FEUTSOP RUDIGER","YAOUNDE-CITY"));
			studentService.saveStudent(new StudentRequestDTO("TEST5","FEUTSOP DIETRICH","DOUALA-CITY"));
		};
	}

}
