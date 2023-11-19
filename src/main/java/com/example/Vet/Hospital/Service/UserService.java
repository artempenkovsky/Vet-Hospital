package com.example.Vet.Hospital.Service;

import com.example.Vet.Hospital.dto.UserDTO;
import com.example.Vet.Hospital.dto.UserRequestDTO;

public interface UserService {
    UserDTO createUser(UserRequestDTO userRequestDTO);
}
