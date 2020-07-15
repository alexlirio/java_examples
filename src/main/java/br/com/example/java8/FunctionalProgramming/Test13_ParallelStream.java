package br.com.example.java8.FunctionalProgramming;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test13_ParallelStream {
	
	public static void main(String[] args) throws IOException {

		// Parallel Streams
		
		// "Parallel Stream" performance better with computers with multiple cores (CPUs) and thousands or millions elements.
		// "Stream" usually performance better with dozens or hundreds of elements.
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		
		// parallel and parallelStrem 
		IntStream parallel = IntStream.range(0, 5).parallel(); // Use "parallel()" from a "Stream"
		Stream<Integer> parallelStream = list.parallelStream(); // Use "parallelStream()" from a "Collection"
		
		
		// forEach - with parallelStream don't use this if the order is important
		list.parallelStream()
			.forEach(System.out::println); // print: ? - will print in random order
		
		// forEachOrdered - with parallelStream use this if the order is important
		list.parallelStream()
			.forEachOrdered(System.out::println); // print: 1234 - will print in original order
		
		System.out.println("---");
		
		// findAny - with parallelStream
		list.parallelStream() // parallelStream
			.findAny()
			.ifPresent(System.out::println); // print: ? - will print a random element
		
		// findAny - with stream
		list.stream() // stream
			.findAny()
			.ifPresent(System.out::println); // print: 1
		
		System.out.println("---");
		
		// unordered
		list.parallelStream()
			.unordered() // unordered allow to apply the methods bellow in any element (the first elements process) 
			.skip(1) // because the "unordered" above, the "skip" will be applied in any element - otherwise it would be applied to the first element (1).
			.limit(2) // because the "unordered" above, the "limit" will be applied in any 2 elements - otherwise it would be applied to the first two elements (2, 3).
			.forEach(System.out::println); // print: ?
		
		System.out.println("---");
		
		// reduce
		// Attention: If you use "parallel (more than one CPU)":
		// 1. Don't use with "not associative functions", when the execution order can change the result (e.g.: subtraction) 
		// 2. Use parallel only with "associative functions", when the execution order don't change the result (e.g.: sum, multiplication and concatenation)
		list.parallelStream()
			.reduce((n1, n2) -> n1 + n2) 
			.ifPresent(System.out::println); // print: ?
		
		System.out.println("---");
		
		// toMap
		// this is not thread-safe - each thread will create map and will merge the result in the end
		// "Map" usually performance better with single thread.
		// the result will return in original order
		Map<Integer, Boolean> collect1 = list.parallelStream()
			.collect(
				Collectors.toMap( // toMap
					n -> n, // keyMapper
					n -> n % 2 == 0 // valueMapper
				)
			);
		System.out.println(collect1);
		
		System.out.println("---");
		
		// toConcurrentMap
		// this is thread-safe - multiple thread will use a single map
		// "ConcurrentMap" usually performance better with multiple thread.
		// the result will return in any order
		Map<Integer, Boolean> collect2 = list.parallelStream()
			.collect(
				Collectors.toConcurrentMap( // toConcurrentMap
					n -> n, // keyMapper
					n -> n % 2 == 0 // valueMapper
				)
			);
		System.out.println(collect2);
		
		System.out.println("---");
		
		// groupingBy
		// this is not thread-safe - each thread will create map and will merge the result in the end
		// "Map" usually performance better with single thread.
		// the result will return in original order
		Map<Boolean, List<Integer>> collect3 = list.parallelStream()
			.collect(
				Collectors.groupingBy(
					n -> n % 2 == 0 // classifier
				)
			);
		System.out.println(collect3);
		
		System.out.println("---");
		
		// groupingByConcurrent
		// this is thread-safe - multiple thread will use a single map
		// "ConcurrentMap" usually performance better with multiple thread.
		// the result will return in any order
		Map<Boolean, List<Integer>> collect4 = list.parallelStream()
				.collect(
						Collectors.groupingByConcurrent(
								n -> n % 2 == 0 // classifier
								)
						);
		System.out.println(collect4);
	}
}
