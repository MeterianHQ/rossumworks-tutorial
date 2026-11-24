package com.meterian.checkout;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class CartLineTest {

    @Test
    void multipliesTheUnitPriceByTheQuantity() {
        assertEquals(new BigDecimal("6.00"), new CartLine("pen", new BigDecimal("1.50"), 4).calculatePrice());
    }

    @Test
    void refusesAQuantityOfZero() {
        assertThrows(IllegalArgumentException.class, () -> new CartLine("pen", BigDecimal.ONE, 0));
    }

    @Test
    void refusesANegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new CartLine("pen", new BigDecimal("-1"), 1));
    }

    @Test
    void refusesAPriceWithThreeDecimals() {
        assertThrows(IllegalArgumentException.class, () -> new CartLine("pen", new BigDecimal("1.005"), 1));
    }
}
