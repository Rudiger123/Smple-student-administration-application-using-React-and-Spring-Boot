package com.rudiger.studentadminsystem.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudiger.studentadminsystem.DTO.StudentRequestDTO;
import com.rudiger.studentadminsystem.DTO.StudentResponseDTO;
import com.rudiger.studentadminsystem.service.StudentService;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentServiceImpl;

    public StudentController(StudentService studentService) {
        this.studentServiceImpl = studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDTO> getStudents() {
        return studentServiceImpl.listStudents();
    }

    @PostMapping("/students")
    public StudentResponseDTO saveStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        // auto generation d'un uuid
        studentRequestDTO.setId(UUID.randomUUID().toString());

        System.out.println("student created successfully !!!");

        return studentServiceImpl.saveStudent(studentRequestDTO);
    }

    @GetMapping("/students/{id}")
    public StudentResponseDTO getStudent(@RequestBody StudentRequestDTO studentRequestDTO,
            @PathVariable(value = "id") final String id) {

        return studentServiceImpl.updateStudent(studentRequestDTO, id);

    }

    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable(value = "id") final String id) {
        return studentServiceImpl.deleteStudent(id);
    }

}
