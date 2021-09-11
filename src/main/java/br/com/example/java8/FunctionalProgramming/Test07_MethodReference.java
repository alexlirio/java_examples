package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;

import com.ibm.icu.math.BigDecimal;

public class Test07_MethodReference {
	
	public static void main(String[] args) {

		// Method Reference
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		list.stream()
			.forEach((e) -> System.out.println(e)); // Without Method Reference - e.g.: (e) -> System.out.println(e)
		
		list.stream()
			.forEach(System.out::println); // With Method Reference - e.g.: System.out::println
		
		
		
		// with static methods examples
		System.out.println("\nwith static methods examples:");
		
		list.stream()
			.map(e -> multiplyByTwo(e)) // Without Method Reference - e.g.: e -> multiplyByTwo(e)
			.forEach(System.out::println);
		
		list.stream()
			.map(Test07_MethodReference::multiplyByTwo) // With Method Reference - e.g.: Test07_MethodReference::multiplyByTwo
			.forEach(System.out::println);
		
		
		
		// with constructor examples
		System.out.println("\nwith constructor examples:");
		
		list.stream()
			.map(e -> new BigDecimal(e)) // Without Method Reference - e.g.: e -> new BigDecimal(e)
			.forEach(System.out::println);
		
		list.stream()
			.map(BigDecimal::new) // With Method Reference - e.g.: BigDecimal::new
			.forEach(System.out::println);
		
		
		
		// with multiple instances examples
		System.out.println("\nwith instance examples:");
		
		list.stream()
			.map(e -> e.doubleValue()) // Without Method Reference - e.g.: e -> e.doubleValue()
			.forEach(System.out::println);
		
		list.stream()
			.map(Integer::doubleValue) // With Method Reference - e.g.: Integer::doubleValue
			.forEach(System.out::println);
		
		
		
		// with single instance examples
		System.out.println("\nwith instance examples:");
		
		BigDecimal two = new BigDecimal(2);
		list.stream()
			.map(BigDecimal::new)
			.map(b -> two.multiply(b)) // Without Method Reference - e.g.: b -> two.multiply(b)
			.forEach(System.out::println);
		
		list.stream()
			.map(BigDecimal::new)
			.map(two::multiply) // With Method Reference - e.g.: two::multiply
			.forEach(System.out::println);
	}
	
	private static Integer multiplyByTwo(Integer i) {
		return i * 2;
	}
}
