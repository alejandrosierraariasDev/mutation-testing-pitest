package com.qualitylabs.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        calculatorService = new CalculatorService();
    }

    @Test
    void add_shouldReturnSum() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    void subtract_shouldReturnDifference() {
        assertEquals(1, calculatorService.subtract(3, 2));
    }

    @Test
    void multiply_shouldReturnProduct() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void divideByZero_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(10, 0);
        });
    }

    @Test
    void divide_shouldReturnResult() {
        assertEquals(5, calculatorService.divide(10, 2));
    }
}