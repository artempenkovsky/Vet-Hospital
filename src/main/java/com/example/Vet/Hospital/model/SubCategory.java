package com.example.Vet.Hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sub_categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "subCategory", cascade = CascadeType.ALL)
    private List<Price> prices = new ArrayList<>();
    @Column(name = "description", nullable = true)
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
