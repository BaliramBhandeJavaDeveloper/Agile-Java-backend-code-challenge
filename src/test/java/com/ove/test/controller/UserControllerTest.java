package com.ove.test.controller;

import com.ove.test.dto.UserDTO;
import com.ove.test.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers_ReturnsListOfUsers() {
        List<UserDTO> mockUsers = List.of(new UserDTO());
        when(userService.getAllUsers()).thenReturn(mockUsers);
        ResponseEntity<List<UserDTO>> response = userController.getAllUsers();
        assertEquals(OK, response.getStatusCode());
        assertEquals(mockUsers, response.getBody());
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserByUsername_ReturnsUser_WhenFound() {
        String username = "balirambhande ";
        UserDTO mockUser = new UserDTO();
        when(userService.getUserByUsername(username)).thenReturn(mockUser);
        ResponseEntity<UserDTO> response = userController.getUserByUsername(username);
        assertEquals(OK, response.getStatusCode());
        assertEquals(mockUser, response.getBody());
        verify(userService, times(1)).getUserByUsername(username);
    }

    @Test
    void testGetUserByUsername_ReturnsNotFound_WhenUserDoesNotExist() {
        String username = "nonexistentuser";
        when(userService.getUserByUsername(username)).thenReturn(null);
        ResponseEntity<UserDTO> response = userController.getUserByUsername(username);
        assertEquals(NOT_FOUND, response.getStatusCode());
        verify(userService, times(1)).getUserByUsername(username);
    }

    @Test
    void testCreateUser_ReturnsCreatedUser() {
        UserDTO inputUser = new UserDTO();
        UserDTO createdUser = new UserDTO();
        when(userService.createUser(inputUser)).thenReturn(createdUser);
        ResponseEntity<UserDTO> response = userController.createUser(inputUser);
        assertEquals(CREATED, response.getStatusCode());
        assertEquals(createdUser, response.getBody());
        verify(userService, times(1)).createUser(inputUser);
    }
}

