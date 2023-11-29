package com.example.Vet.Hospital.service;

import com.example.Vet.Hospital.dto.SubCategoryDTO;

import java.util.List;

public interface SubCategoryService {
    SubCategoryDTO addSubCategory(SubCategoryDTO subCategory);

    List<SubCategoryDTO> getAllCategories(Integer categoryId);
}
