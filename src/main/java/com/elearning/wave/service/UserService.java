package com.elearning.wave.service;

import com.elearning.wave.dto.AuthResponseDTO;
import com.elearning.wave.dto.LoginDTO;
import com.elearning.wave.dto.RegisterDTO;
import com.elearning.wave.dto.UserDTO;
import com.elearning.wave.model.base.Users;
import com.elearning.wave.repository.UserRepository;
import com.elearning.wave.security.JWTGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public UserService(UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
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

    public String register(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new IllegalArgumentException("email already taken");
        }

        String hashedPassword = this.passwordEncoder.encode(registerDTO.getPassword());
        Users users = new Users();
        users.setFullname(registerDTO.getFullname());
        users.setEmail(registerDTO.getEmail());
        users.setPassword(hashedPassword);
        userRepository.save(users);
        return "User register success";
    }

    public AuthResponseDTO authenticateUser(LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getEmail(),
                            loginDTO.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication);
            String token = jwtGenerator.generateToken(authentication);
            return new AuthResponseDTO(token);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid email or password", e);
        }
    }
}
