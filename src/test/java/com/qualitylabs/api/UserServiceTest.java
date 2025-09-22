package com.qualitylabs.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void isValidAge_withValidAge_shouldReturnTrue() {
        // Este test pasa, pero no comprueba el caso de borde
        assertTrue(userService.isValidAge(20));
    }

    @Test
    void isValidAge_withInvalidAge_shouldReturnFalse() {
        assertFalse(userService.isValidAge(16));
    }

    @Test
    void getWelcomeMessage_withValidName_shouldReturnWelcomeMessage() {
        assertEquals("¡Bienvenido, Alex!", userService.getWelcomeMessage("Alex"));
    }

    @Test
    void getWelcomeMessage_withEmptyName_shouldReturnGuestMessage() {
        assertEquals("¡Bienvenido, invitado!", userService.getWelcomeMessage(""));
    }
}