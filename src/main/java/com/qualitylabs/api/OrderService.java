package com.qualitylabs.api;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    /**
     * Checks if a discount is applicable based on amount and quantity.
     * A discount is applicable if the total amount is over 100 OR the quantity is over 5.
     */
    public boolean isDiscountApplicable(double amount, int quantity) {
        if (amount > 100 || quantity > 5) {
            return true;
        }
        return false;
    }

    /**
     * Processes an order and returns a confirmation message.
     */
    public String processOrder(String orderId) {
        if (orderId == null || orderId.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be empty.");
        }
        return "Order " + orderId + " has been processed.";
    }
}