package com.example.Vet.Hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "role", unique = true)
    private String role;
    @OneToMany(mappedBy = "userRole", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    @Override
    public String getAuthority() {
        return role;
    }
}
