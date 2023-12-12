package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.SubCategoryDTO;
import com.example.Vet.Hospital.model.Price;
import com.example.Vet.Hospital.model.SubCategory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SubCategoryToSubCategoryDTOTransformer extends Transformer<SubCategoryDTO, SubCategory> {
    @Override
    public SubCategoryDTO transform(SubCategory subCategory) {
        SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
        subCategoryDTO.setId(subCategory.getId());
        subCategoryDTO.setName(subCategory.getName());
        subCategoryDTO.setDescription(subCategory.getDescription());
        subCategoryDTO.setCategoryId(subCategory.getCategory().getId());
        BigDecimal price = subCategory
                .getPrices()
                .stream()
                .filter(Price::isActive)
                .map(Price::getPrice)
                .findFirst()
                .orElse(null);
        subCategoryDTO.setPrice(price);
        return subCategoryDTO;
    }
}
