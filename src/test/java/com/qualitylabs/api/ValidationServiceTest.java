package com.qualitylabs.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest {

    private ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationService();
    }

    @Test
    void isValidEmail_withValidEmail_shouldReturnTrue() {
        // Este test no valida si hay un punto o un @ al final
        assertTrue(validationService.isValidEmail("test@example.com"));
    }

    @Test
    void isValidEmail_withInvalidEmail_shouldReturnFalse() {
        // Este test no valida si el email no contiene un "."
        assertFalse(validationService.isValidEmail("test@example"));
    }

    @Test
    void isPasswordComplex_withSimplePassword_shouldBeFalse() {
        // Este test solo comprueba la longitud
        assertFalse(validationService.isPasswordComplex("short"));
    }

    @Test
    void isPasswordComplex_withComplexPassword_shouldBeTrue() {
        // Este test solo comprueba un caso simple, no todos los criterios
        assertTrue(validationService.isPasswordComplex("Pass1234"));
    }
}