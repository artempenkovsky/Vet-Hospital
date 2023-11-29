package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.SubCategoryDTO;
import com.example.Vet.Hospital.model.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryToSubCategoryDTOTransformer extends Transformer<SubCategoryDTO, SubCategory> {
    @Override
    public SubCategoryDTO transform(SubCategory subCategory) {
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
        subCategoryDTO.setId(subCategory.getId());
        subCategoryDTO.setName(subCategory.getName());
        subCategoryDTO.setDescription(subCategory.getDescription());
        subCategoryDTO.setCategoryId(subCategory.getCategory().getId());
        return subCategoryDTO;
    }
}
