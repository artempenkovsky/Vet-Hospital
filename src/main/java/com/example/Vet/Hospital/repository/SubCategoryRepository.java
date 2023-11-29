package com.example.Vet.Hospital.repository;

import com.example.Vet.Hospital.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> findByCategory_Id(Integer categoryId);

}
