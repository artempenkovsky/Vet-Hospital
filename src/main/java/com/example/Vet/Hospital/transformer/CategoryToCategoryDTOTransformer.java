package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.CategoryDTO;
import com.example.Vet.Hospital.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryDTOTransformer extends Transformer<CategoryDTO, Category>{
    @Override
    public CategoryDTO transform(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
