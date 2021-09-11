package br.com.example.designpattern.behavioral.strategy;

import java.math.BigDecimal;

public class DiscountStrategyTest {

    public static void main(String[] args) {
        BigDecimal value = BigDecimal.valueOf(100);
        
        DiscountStrategy christmasDiscount = new ChristmasDiscount();
        DiscountStrategy easterDiscount = new EasterDiscount();

        System.out.println("Full value: " + value);
        System.out.println("ChristmasDiscount: " + christmasDiscount.applyDiscount(value));
        System.out.println("EasterDiscount: " + easterDiscount.applyDiscount(value));
    }
}
