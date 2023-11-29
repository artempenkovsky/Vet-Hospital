package com.example.Vet.Hospital.service.impl;

import com.example.Vet.Hospital.dto.CategoryDTO;
import com.example.Vet.Hospital.model.Category;
import com.example.Vet.Hospital.repository.CategoryRepository;
import com.example.Vet.Hospital.repository.SubCategoryRepository;
import com.example.Vet.Hospital.service.CategoryService;
import com.example.Vet.Hospital.transformer.CategoryToCategoryDTOTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryToCategoryDTOTransformer categoryToCategoryDTOTransformer;
    private final SubCategoryRepository subCategoryRepository;

    @Override
    public CategoryDTO addCategory(Category category) {
        Category save = categoryRepository.save(category);
        return categoryToCategoryDTOTransformer.transform(save);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository
                .findAll()
                .stream()
                .map(categoryToCategoryDTOTransformer::transform)
                .collect(Collectors.toList());
    }
}
