package com.rudiger.studentadminsystem.mappers;

import org.mapstruct.Mapper;

import com.rudiger.studentadminsystem.DTO.StudentRequestDTO;
import com.rudiger.studentadminsystem.DTO.StudentResponseDTO;
import com.rudiger.studentadminsystem.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentResponseDTO studentToStudentResponseDTO(Student student);

    Student studentResquestToStudent(StudentRequestDTO studentRequestDTO);
    
} 
