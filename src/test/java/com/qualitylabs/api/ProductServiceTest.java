package com.qualitylabs.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService();
    }

    @Test
    void calculateDiscountedPrice_withValidInput_shouldReturnCorrectPrice() {
        // This test only validates the "happy path"
        double finalPrice = productService.calculateDiscountedPrice(100.0, 20.0);
        assertEquals(80.0, finalPrice);
    }

    @Test
    void isProductAvailable_withValidId_shouldReturnTrue() {
        // This test is weak and won't cover null or empty string cases
        boolean isAvailable = productService.isProductAvailable("A123");
        assertTrue(isAvailable);
    }

    @Test
    void isProductAvailable_withNullId_shouldReturnFalse() {
        boolean isAvailable = productService.isProductAvailable(null);
        assertFalse(isAvailable);
    }
}