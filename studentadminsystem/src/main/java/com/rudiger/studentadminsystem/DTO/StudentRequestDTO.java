package com.rudiger.studentadminsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class StudentRequestDTO {
    
    private String id;
    private String name;
    private String address;

}
