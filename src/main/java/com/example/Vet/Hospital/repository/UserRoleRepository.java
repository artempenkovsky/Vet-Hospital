package com.example.Vet.Hospital.repository;

import com.example.Vet.Hospital.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {
    Optional<UserRole> findByRole(String role);
}
