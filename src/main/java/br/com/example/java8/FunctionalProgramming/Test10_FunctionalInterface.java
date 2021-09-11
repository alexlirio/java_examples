package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Test10_FunctionalInterface {
	
	public static void main(String[] args) {

		/*******************************/
		/* Functional Interfaces Types */
		/*******************************/
		// Supplier<T>: This not receive argument() and return "T"
		// Consumer<T>: This receive one argument(T t) and return "void"
		// BiConsumer<T, U>: This receive two arguments(T t, U u) and return "void"
		// Predicate<T>: This receive one argument(T t) and return a "boolean"
		// BiPredicate<T, U>: This receive two arguments(T, U) and return a "boolean"
		// Function<T>: This receive one argument(T t) and return R
		// BiFunction<T, R>: This receive two arguments(T t, U u) and return R
		// UnaryOperator<T>: This receive one argument(T t) and return T. The receive and return has the same type "T"
		// BinaryOperator<T>: This receive two arguments(T t, T t) and return T. The receive and return has the same type "T"
		
		Stream
			.generate(() -> new Random().nextInt()) // Supplier<T> use example
			.limit(5)
			.forEach((e) -> System.out.println(e)); // Consumer<T> use example
		
		System.out.println();
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream()
			.filter(e -> e % 2 == 0) // Predicate<T> use example
			.map(e -> e.doubleValue()) // Function<T, R> use example
			.reduce((e1, e2) -> e1 + e2) // BinaryOperator<T> use example
			.ifPresent(System.out::println); // Consumer<T> use example with "Method Reference"
	}
}
