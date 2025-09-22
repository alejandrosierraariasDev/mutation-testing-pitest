package com.qualitylabs.api;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    /**
     * Validates a basic email format.
     */
    public boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    /**
     * Checks if a password is complex.
     */
    public boolean isPasswordComplex(String password) {
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasUppercase = !password.equals(password.toLowerCase());
        return password.length() >= 8 && hasDigit && hasUppercase;
    }
}