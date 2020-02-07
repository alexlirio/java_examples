package br.com.example.hackerrank;

public class Solution11 {
	
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
    	System.out.println((int) Math.round(meal_cost + (meal_cost / 100 * tip_percent) + (meal_cost / 100 * tax_percent)));
    }
	
    public static void main(String[] args) {
    	
    	double meal_cost = 12.00;
    	int tip_percent = 20;
    	int tax_percent = 8;
    	
    	solve(meal_cost, tip_percent, tax_percent);
    	
    }
}