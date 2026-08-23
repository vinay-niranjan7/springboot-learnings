package com.vinay7.TestingDemo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PriceCalculatorTest {

    private PriceCalculator priceCalculator;

    @BeforeEach
    void setup() {
        priceCalculator = new PriceCalculator();
    }


    @Test
    void shouldApplyDiscountToPrice() {

        // arrange
        double price = 1000;
        double discount = 20;

        //act
        double actualPrice =
                priceCalculator.calculatePrice(price, discount);

        // assertion
        assertEquals(800, actualPrice);
    }

    @Test
    void shouldRejectInvalidDiscount() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> priceCalculator.calculatePrice(
                                1000,
                                -10
                        )
                );

        assertEquals("Discount should be within 0 to 100",
                exception.getMessage());
    }
}