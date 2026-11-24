package com.meterian.checkout;

import java.math.BigDecimal;

public record CartLine(String product, BigDecimal unitPrice, int quantity) {

    public CartLine {
        if (unitPrice.signum() < 0) {
            throw new IllegalArgumentException("The unit price must not be negative.");
        }
        if (unitPrice.stripTrailingZeros().scale() > 2) {
            throw new IllegalArgumentException("The unit price must have 2 decimals or less.");
        }
        if (quantity < 1) {
            throw new IllegalArgumentException("The quantity must be 1 or more.");
        }
    }

    public BigDecimal calculatePrice() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
}
