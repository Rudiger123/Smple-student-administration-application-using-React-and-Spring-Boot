package com.rudiger.studentadminsystem.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rudiger.studentadminsystem.DTO.StudentRequestDTO;
import com.rudiger.studentadminsystem.DTO.StudentResponseDTO;
import com.rudiger.studentadminsystem.mappers.StudentMapper;
import com.rudiger.studentadminsystem.model.Student;
import com.rudiger.studentadminsystem.repository.StudentRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentResponseDTO> listStudents() {
        List<Student> students = studentRepository.findAll();

        List<StudentResponseDTO> studentResponseDTOs = students.stream()
                .map(student -> studentMapper.studentToStudentResponseDTO(student)).collect(Collectors.toList());

        return studentResponseDTOs;

    }

    @Override
    public StudentResponseDTO saveStudent(@RequestBody StudentRequestDTO studentRequestDTO) {
        Student student = studentMapper.studentResquestToStudent(studentRequestDTO);

        if (student.getName() != null && student.getAddress() != null) {
            student = studentRepository.save(student);
        }else{
            System.out.println("invalid name and address value");
        }
       

        StudentResponseDTO studentResponseDTO = studentMapper.studentToStudentResponseDTO(student);

        return studentResponseDTO;
    }

    @Override
    public StudentResponseDTO updateStudent(StudentRequestDTO studentRequestDTO, String id) {
        Student student = studentMapper.studentResquestToStudent(studentRequestDTO);

        Student studentUpdated = studentRepository.findById(id).get();

        // verifier que les donnees ne sont pas nulles
        studentUpdated = student;

        // sauvegarder les modifications...
        studentUpdated = studentRepository.save(studentUpdated);

        return studentMapper.studentToStudentResponseDTO(studentUpdated);

    }

    @Override
    public StudentResponseDTO getStudent(String id) {
        Student student = studentRepository.findById(id).get();

        return studentMapper.studentToStudentResponseDTO(student);
    }

    @Override
    public String deleteStudent(String id) {
        studentRepository.deleteById(id);

        return "Student deleted successfully !!!";
    }

}
