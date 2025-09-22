package com.qualitylabs.api;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

    /**
     * Calculates the discounted price of a product.
     * @param originalPrice The original price of the product.
     * @param discountPercentage The discount percentage (e.g., 20 for 20%).
     * @return The final price after the discount.
     */
    public double calculateDiscountedPrice(double originalPrice, double discountPercentage) {
        if (discountPercentage < 0 || discountPercentage > 100) {
            throw new IllegalArgumentException("Discount percentage must be between 0 and 100.");
        }

        double finalPrice = originalPrice - (originalPrice * discountPercentage / 100);

        // This is a defensive check that our tests won't cover,
        // so Pitest will create a "survived" mutant here.
        if (finalPrice < 0) {
            return 0;
        }

        return finalPrice;
    }

    public boolean isProductAvailable(String productId) {
        // Assume this method checks a database. Our test for this will be very basic.
        return productId != null && !productId.isEmpty();
    }
}