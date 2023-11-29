package com.example.Vet.Hospital.service.impl;

import com.example.Vet.Hospital.dto.SubCategoryDTO;
import com.example.Vet.Hospital.model.SubCategory;
import com.example.Vet.Hospital.repository.SubCategoryRepository;
import com.example.Vet.Hospital.service.SubCategoryService;
import com.example.Vet.Hospital.transformer.SubCategoryDtoToSubCategoryTransformer;
import com.example.Vet.Hospital.transformer.SubCategoryToSubCategoryDTOTransformer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryDtoToSubCategoryTransformer subCategoryTransformer;
    private final SubCategoryToSubCategoryDTOTransformer subCategoryToSubCategoryDTOTransformer;
    @Override
    public SubCategoryDTO addSubCategory(SubCategoryDTO subCategoryDTO) {
        SubCategory subCategory = subCategoryTransformer.transform(subCategoryDTO);
        SubCategory save = subCategoryRepository.save(subCategory);
        SubCategoryDTO transform = subCategoryToSubCategoryDTOTransformer.transform(save);
        return transform;
    }

    @Override
    public List<SubCategoryDTO> getAllCategories(Integer categoryId) {
        return subCategoryRepository
                .findByCategory_Id(categoryId)
                .stream()
                .map(subCategoryToSubCategoryDTOTransformer ::transform)
                .collect(Collectors.toList());
    }
}
