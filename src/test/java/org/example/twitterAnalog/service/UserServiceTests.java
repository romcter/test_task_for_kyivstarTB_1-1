package org.example.twitterAnalog.service;

import org.example.twitterAnalog.enity.User;
import org.example.twitterAnalog.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterUser() {
        User user = new User();
        user.setUsername("testuser");

        when(userRepository.save(user)).thenReturn(user);

        User result = userService.registerUser(user);
        assertEquals("testuser", result.getUsername());
    }

}