package com.rudiger.studentadminsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rudiger.studentadminsystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    
}
