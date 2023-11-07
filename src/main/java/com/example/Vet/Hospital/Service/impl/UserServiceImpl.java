package com.example.Vet.Hospital.Service.impl;

import com.example.Vet.Hospital.Service.UserService;
import com.example.Vet.Hospital.model.User;
import com.example.Vet.Hospital.model.UserRole;
import com.example.Vet.Hospital.repository.UserRepository;
import com.example.Vet.Hospital.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;
    @Override
    public User createUser(User user) {
        Optional<User> login = userRepository.findByLogin(user.getLogin());
        if (login.isPresent()){
            throw new IllegalArgumentException("Такой логин уже испольуется в системе!");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Optional<UserRole> roleClient = userRoleRepository.findByRole("ROLE_CLIENT");
            if (!roleClient.isPresent()) {
                throw new IllegalArgumentException("Такой роли не существует в системе!");
            } else {
                user.setUserRole(roleClient.get());
                return userRepository.save(user);
            }
        }
    }
}
