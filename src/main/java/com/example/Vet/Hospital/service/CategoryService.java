package com.example.Vet.Hospital.service;

import com.example.Vet.Hospital.dto.CategoryDTO;
import com.example.Vet.Hospital.model.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO addCategory(Category category);

    List<CategoryDTO> getAllCategories();
}

