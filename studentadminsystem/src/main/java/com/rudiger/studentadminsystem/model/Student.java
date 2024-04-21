package com.rudiger.studentadminsystem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    //constructeur a deux arguments
    public Student(String name , String address)
    {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "Student [ name = " + name + ", address = "+ address + "]";
    }

    
}
