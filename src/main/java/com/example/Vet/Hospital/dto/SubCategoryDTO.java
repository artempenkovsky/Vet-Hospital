package com.example.Vet.Hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryDTO {
    private int id;
    private String name;
    private BigDecimal price;
    private String description;
    private int categoryId;
}
