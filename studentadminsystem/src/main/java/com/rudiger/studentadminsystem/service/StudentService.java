package com.rudiger.studentadminsystem.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.rudiger.studentadminsystem.DTO.StudentRequestDTO;
import com.rudiger.studentadminsystem.DTO.StudentResponseDTO;

public interface StudentService {

    //methode permettant de lister l'ensemble des eleves
    public List<StudentResponseDTO> listStudents();

    //methode pour ajouter un nouvel eleve
    public StudentResponseDTO saveStudent(@RequestBody StudentRequestDTO studentRequestDTO);

    //mettre a jour les informations d'un eleve
    public StudentResponseDTO updateStudent(@RequestBody StudentRequestDTO studentRequestDTO , @PathVariable(value = "id") final String id);

    //voir les details d'un eleve
    public StudentResponseDTO getStudent(@PathVariable(value = "id") final String id);

    //delete a student 
    public String deleteStudent(@PathVariable(value = "id")final String id);
}
