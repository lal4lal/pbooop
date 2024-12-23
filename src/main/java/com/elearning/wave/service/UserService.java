package com.elearning.wave.service;

import com.elearning.wave.dto.UserDTO;
import com.elearning.wave.model.base.Users;
import com.elearning.wave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO convertEntityToUserDto(Users users) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(users.getUserId());
        userDTO.setFullname(users.getFullname());
        userDTO.setEmail(users.getEmail());
        userDTO.setUsername(users.getUsername());

        return userDTO;
    }

    public Optional<UserDTO> getUserById(long userId) {
        return userRepository.findById(userId)
                .map(this::convertEntityToUserDto);
    }

    public Optional<Users> findById(long userId) {
        return userRepository.findById(userId);
    }
}
