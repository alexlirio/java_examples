package br.com.example.designpattern.behavioral.strategy;

import java.math.BigDecimal;

public class ChristmasDiscount implements DiscountStrategy {

    @Override
    public BigDecimal applyDiscount(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.9));
    }
}
