package com.elearning.wave.service;

import com.elearning.wave.dto.RegisterDTO;
import com.elearning.wave.dto.UserDTO;
import com.elearning.wave.model.base.Users;
import com.elearning.wave.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO convertEntityToUserDto(Users users) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(users.getUserId());
        userDTO.setFullname(users.getFullname());
        userDTO.setEmail(users.getEmail());

        return userDTO;
    }

    public Optional<UserDTO> getUserById(long userId) {
        return userRepository.findById(userId)
                .map(this::convertEntityToUserDto);
    }

    public Optional<Users> findById(long userId) {
        return userRepository.findById(userId);
    }

    public void register(RegisterDTO registerDTO) {
        Optional<Users> usersOptional = userRepository.findByFullnameAndEmail(registerDTO.getFullname(), registerDTO.getEmail());

        if (usersOptional.isPresent()) {
            throw new IllegalStateException("Account Already Exist");
        }

        if (userRepository.findByEmail(registerDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("email already taken");
        }

        String hashedPassword = this.passwordEncoder.encode(registerDTO.getPassword());
        Users users = new Users();
        users.setFullname(registerDTO.getFullname());
        users.setEmail(registerDTO.getEmail());
        users.setPassword(hashedPassword);
        userRepository.save(users);
    }
}
