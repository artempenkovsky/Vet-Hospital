package com.example.Vet.Hospital.controller;

import com.example.Vet.Hospital.dto.CategoryDTO;
import com.example.Vet.Hospital.dto.SubCategoryDTO;
import com.example.Vet.Hospital.model.Category;
import com.example.Vet.Hospital.service.impl.CategoryServiceImpl;
import com.example.Vet.Hospital.service.impl.SubCategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Slf4j

public class AdminController {
    private final CategoryServiceImpl categoryService;
    private final SubCategoryServiceImpl subCategoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        CategoryDTO categoryDTO = categoryService.addCategory(category);
        log.info("Create category: " + categoryDTO.getName());
        return ResponseEntity.ok(categoryDTO);
    }

    @PostMapping("/addSubCategory")
    public ResponseEntity<?> addSubCategory(@RequestBody SubCategoryDTO subCategory) {
        SubCategoryDTO subCategoryDTO = subCategoryService.addSubCategory(subCategory);
        log.info("Create subCategory: " + subCategoryDTO.getName());
        return ResponseEntity.ok(subCategoryDTO);
    }
}
