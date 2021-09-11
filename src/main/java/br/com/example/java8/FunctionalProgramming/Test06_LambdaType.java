package br.com.example.java8.FunctionalProgramming;

import java.util.stream.IntStream;

public class Test06_LambdaType {

	public static void main(String[] args) {
		
		// Lambda Types
		
		// Lambda use SAM (Single Abstract Method)
		// SAM is an interface with only one abstract method. It's a "@FunctionalInterface". 
		
		
		
		// Parentheses() is mandatory:
		// 1. if you don't pass one parameter. e.g.: () -> System.out.println("Hello World!")
		// 2. if you need explicit the type. e.g.: (int n) -> n % 2 == 0
		// 3. if you need to pass more than one parameter. e.g.: (n1, n2) -> n1 + n2
		System.out.println("Examples whith mandatory parentheses()");
		
		Runnable r = () -> System.out.println("Hello World!"); // e.g.: () -> body implementation - if you don't pass one parameter, use "()".
		r.run();
		
		IntStream.range(0, 5)
			.filter(n -> n % 2 == 0) // e.g.: parameter -> body implementation
			.filter((int n) -> n % 2 == 0) // e.g.: (type parameter) -> body implementation - if you need explicit the type (in this case "int").
			.reduce((n1, n2) -> n1 + n2) // e.g.: (parameter, parameter) -> body implementation - if you need to pass more than one parameter.
			.ifPresent(System.out::println);
		
		
		
		// Braces{} is mandatory:
		// 1. if you need two or more lines to implementation - each line implementation need finish with ";" 
		System.out.println("\nExamples with mandatory braces{}");
		
		// parameter -> {body implementation}
		IntStream.range(0, 5)
			.filter(n -> {
				System.out.println("Hello World!");
				return n % 2 == 0; // is mandatory add "return" - if the implementation return something
			})
			.forEach(n -> System.out.println(n));
	}
}
