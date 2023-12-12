package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.SubCategoryDTO;
import com.example.Vet.Hospital.model.Category;
import com.example.Vet.Hospital.model.SubCategory;
import com.example.Vet.Hospital.repository.CategoryRepository;
import com.example.Vet.Hospital.repository.SubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubCategoryDtoToSubCategoryTransformer extends Transformer<SubCategory, SubCategoryDTO>{
    private final CategoryRepository categoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    @Override
    public SubCategory transform(SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = subCategoryRepository.findById(subCategoryDTO.getId()).orElse(null);
//        subCategory.setId(subCategoryDTO.getId());
//        subCategory.setName(subCategoryDTO.getName());
//        subCategory.setDescription(subCategoryDTO.getDescription());
        Category category = categoryRepository.findById(subCategoryDTO.getCategoryId()).orElseThrow(() ->
                new IllegalArgumentException("Произошла ошибка: нет такой категории" + subCategoryDTO.getCategoryId()));
        subCategory.setCategory(category);
        return subCategory;
    }
}
