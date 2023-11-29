package com.example.Vet.Hospital.repository;

import com.example.Vet.Hospital.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface CategoryRepository extends JpaRepository<Category, Integer> {
}
