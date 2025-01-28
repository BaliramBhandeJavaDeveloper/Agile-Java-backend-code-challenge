package com.ove.test.service;

import com.ove.test.dto.UserDTO;
import com.ove.test.exception.UsernameAlreadyExistsException;
import com.ove.test.model.UserDetails;
import com.ove.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Convert User entity to UserDTO
    private UserDTO convertToDTO(UserDetails userDetails) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(userDetails.getUsername());
        userDTO.setName(userDetails.getName());
        userDTO.setEmail(userDetails.getEmail());
        userDTO.setGender(userDetails.getGender());
        userDTO.setPictureUrl(userDetails.getPictureUrl());
        return userDTO;
    }

    // Convert UserDTO to User entity
    private UserDetails convertToEntity(UserDTO userDTO) {
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(userDTO.getUsername());
        userDetails.setName(userDTO.getName());
        userDetails.setEmail(userDTO.getEmail());
        userDetails.setGender(userDTO.getGender());
        userDetails.setPictureUrl(userDTO.getPictureUrl());
        return userDetails;
    }

    // Get all users and return as a list of UserDTO
    public List<UserDTO> getAllUsers() {
        List<UserDetails> userDetails = userRepository.findAll();
        return userDetails.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get user by username and return as UserDTO
    public UserDTO getUserByUsername(String username) {
        UserDetails userDetails = userRepository.findByUsername(username);
        return convertToDTO(userDetails);
    }

    // Create a new user from UserDTO
    public UserDTO createUser(UserDTO userDTO) {
        // Check if the username already exists
        if (userRepository.findByUsername(userDTO.getUsername()) != null) {
            throw new UsernameAlreadyExistsException("Username '" + userDTO.getUsername() + "' already exists.");
        }

        UserDetails userDetails = convertToEntity(userDTO);
        UserDetails savedUserDetails = userRepository.save(userDetails);
        return convertToDTO(savedUserDetails);
    }
}
