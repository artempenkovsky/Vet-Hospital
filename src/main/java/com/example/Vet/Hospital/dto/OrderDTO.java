package com.example.Vet.Hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Integer id;

    private UserDTO userDTO;

    private SubCategoryDTO subCategoryDTO;

    private LocalDate dateOfCreate;

    private String status;
}
