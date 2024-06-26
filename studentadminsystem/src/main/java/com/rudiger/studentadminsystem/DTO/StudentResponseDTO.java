package com.rudiger.studentadminsystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class StudentResponseDTO {
    private String id;
    private String name;
    private String address;
}
