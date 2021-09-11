package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public class Test04_Reduce {

	public static void main(String[] args) {
		
		// Reduce
		// Transform all element in only one
		// Reduce is to work with "immutable" (e.g.: String or Number). Don't use with "mutable" (e.g.: StringBuilder)
		
		// Attention: If you use "parallel (more than one CPU)":
		// 1. Don't use with "not associative functions", when the execution order can change the result (e.g.: subtraction) 
		// 2. Use parallel only with "associative functions", when the execution order don't change the result (e.g.: sum, multiplication and concatenation)
		
		List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		Optional<Integer> r1 = l1.stream()
				.reduce((e1, e2) -> e1 + e2); // return the sum
		System.out.println(r1.get()); // print: 21
		
		Optional<Integer> r2 = l1.stream()
				.reduce((e1, e2) -> e1 * e2); // return the multiplication
		System.out.println(r2.get()); // print: 720
		
		
		List<String> l2 = Arrays.asList("Hello world!".split(" "));
		
		Optional<String> r3 = l2.stream()
				.reduce((e1, e2) -> e1.concat(e2)); // return the concatenation
		System.out.println(r3.get()); // print: Helloworld!

		
		System.out.println("\nParallel execution examples:");
		
		Optional<Integer> r4 = l1.stream()
				.parallel() // Attention: Parallel (more than one CPU) activated - in this case the execution order is not always the same
				.reduce((e1, e2) -> e1 - e2); // return the subtraction
		System.out.println(r4.get()); // print: ? (*The result depends of the execution order)
		
		
		System.out.println("\nWith 'Identity' examples:");
		
		// "Identity" is a value you can use as one of the two parameters and the result will be equal the another parameter.
		// e.g.: 0+3=3 - '0' is the identity in sum, because the result is equal the another parameter '3'.
		// If the Stream is empty it will return the identity value.
		Integer r5 = l1.stream()
				.reduce(0, (e1, e2) -> e1 + e2); // return the sum
		System.out.println(r5); // print: 21
		
		// e.g.: x.concat(y) - "" is the identity in concatenation function, because the result is equal the another parameter.
		String r6 = l2.stream()
				.reduce("", (e1, e2) -> e1.concat(e2)); // return the min
		System.out.println(r6); // print: Helloworld!
		
		// e.g.: Math.min(e1, e2) - 'Double.POSITIVE_INFINITY' is the identity in min function, because the result is equal the another parameter.
		double r7 = DoubleStream.of(1.5, 2.9, 6.7)
				.reduce(Double.POSITIVE_INFINITY, (e1, e2) -> Math.min(e1, e2)); // return the min
		System.out.println(r7); // print: 1.5
		
		List<Integer> l5 = Arrays.asList();
		System.out.println(l5.stream().reduce(0, (e1, e2) -> e1 + e2)); // print: 0 - If the Stream is empty it will return the identity value - in this case '0'.
		
		
		// e.g.: reduce - map + combiner (*To use with parallel - more than one thread - see the parallel example class)
		String r8 = Arrays.asList("A", "B", "C", "D", "E").stream()
				.reduce(
						"", // identity
						(e1, e2) -> e1.toString().concat(e2.toString()), // accumulator
						(e1, e2) -> e1.concat(e2) // combiner
				);
		System.out.println(r8); // print: ABCDE
	}
}
