package com.example.Vet.Hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "date_of_start", nullable = false)
    private LocalDate dateOfStart;

    @Column(name = "date_of_end")
    private LocalDate dateOfEnd;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategory subCategory;

}
