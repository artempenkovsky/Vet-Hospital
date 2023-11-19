package com.example.Vet.Hospital.transformer;

import com.example.Vet.Hospital.dto.UserDTO;
import com.example.Vet.Hospital.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTOTransformer extends Transformer<UserDTO, User> {
    @Override
    public UserDTO transform(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setSecondName(user.getSecondName());
        userDTO.setLogin(user.getLogin());
        userDTO.setUserRole(user.getUserRole().getRole());
        return userDTO;
    }
}
