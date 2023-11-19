package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.UserRequestDTO;
import com.example.Vet.Hospital.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDTOToUserTransformer extends Transformer<User, UserRequestDTO> {
    @Override
    public User transform(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setFirstName(userRequestDTO.getFirstName());
        user.setSecondName(userRequestDTO.getSecondName());
        user.setLogin(userRequestDTO.getLogin());
        return user;
    }
}
