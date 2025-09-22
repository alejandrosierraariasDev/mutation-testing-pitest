package com.qualitylabs.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    void isDiscountApplicable_withHighAmount_shouldBeTrue() {
        // This test only covers one part of the condition (amount > 100)
        assertTrue(orderService.isDiscountApplicable(150.0, 3));
    }

    @Test
    void isDiscountApplicable_withLowValues_shouldBeFalse() {
        assertFalse(orderService.isDiscountApplicable(50.0, 2));
    }

    @Test
    void processOrder_withValidId_shouldReturnConfirmationMessage() {
        assertEquals("Order ABC-123 has been processed.", orderService.processOrder("ABC-123"));
    }

    // Este test mata al mutante que cambia "||" por "&&".
    // Sin él, un test que solo valide el importe alto y no la cantidad, dejaría sobrevivir a un mutante.
    @Test
    void isDiscountApplicable_withHighQuantity_shouldBeTrue() {
        assertTrue(orderService.isDiscountApplicable(50.0, 8));
    }
}