package br.com.example.designpattern.behavioral.strategy;

import java.math.BigDecimal;

/**
 * Strategy:
 * Recognizable by behavioral methods in an abstract/interface type which invokes a method in an implementation 
 * of a different abstract/interface type which has been passed-in as method argument into the strategy implementation.
 */
public interface DiscountStrategy {
    BigDecimal applyDiscount(BigDecimal amount);
}
