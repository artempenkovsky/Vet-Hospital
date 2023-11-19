package com.example.Vet.Hospital.Service.impl;

import com.example.Vet.Hospital.Service.UserService;
import com.example.Vet.Hospital.dto.UserDTO;
import com.example.Vet.Hospital.dto.UserRequestDTO;
import com.example.Vet.Hospital.model.User;
import com.example.Vet.Hospital.model.UserRole;
import com.example.Vet.Hospital.repository.UserRepository;
import com.example.Vet.Hospital.repository.UserRoleRepository;
import com.example.Vet.Hospital.transformer.UserRequestDTOToUserTransformer;
import com.example.Vet.Hospital.transformer.UserToUserDTOTransformer;
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
    private final UserToUserDTOTransformer transformer;
    private final UserRequestDTOToUserTransformer userRequestDTOToUserTransformer;
    @Override
    public UserDTO createUser(UserRequestDTO userRequestDTO) {
        Optional<User> login = userRepository.findByLogin(userRequestDTO.getLogin());
        if (login.isPresent()){
            throw new IllegalArgumentException("Такой логин уже испольуется в системе!");
        } else {
            User user = userRequestDTOToUserTransformer.transform(userRequestDTO);
            user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
            Optional<UserRole> roleClient = userRoleRepository.findByRole("ROLE_CLIENT");
            if (!roleClient.isPresent()) {
                throw new IllegalArgumentException("Такой роли не существует в системе!");
            } else {
                user.setUserRole(roleClient.get());
                return transformer.transform(userRepository.save(user));
            }
        }
    }
}
