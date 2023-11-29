package com.example.Vet.Hospital.controller;

import com.example.Vet.Hospital.dto.SubCategoryDTO;
import com.example.Vet.Hospital.service.SubCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subCategory")
@RequiredArgsConstructor
@Slf4j
public class SubCategoryController {
    private final SubCategoryService subCategoryService;
    @GetMapping("/{categoryId}")
    public ResponseEntity<List<SubCategoryDTO>> getAllSubCategories(@PathVariable Integer categoryId){
        List<SubCategoryDTO> allSubCategories = subCategoryService.getAllCategories(categoryId);
        return ResponseEntity.ok(allSubCategories);
    }
}
