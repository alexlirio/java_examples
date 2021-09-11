package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.List;

public class Test08_DebugStream {
	
	public static void main(String[] args) {

		// Debug Stream
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		
		// original lambda
		list.stream()
			.map(e -> new StringBuilder().append(e).append("s").append("a"))
			.forEach(System.out::println);
		
		// debug method 1 - original lambda converted to block
		list.stream()
		.map(e -> {
			return stringBuilderConverter(e);
		})
		.forEach(System.out::println);
		
		// debug method 2 - original lambda converted to method
		list.stream()
			.map(e -> stringBuilderConverter(e))
			.forEach(System.out::println);
		
		// debug method 3 - peek
		list.stream()
			.peek(n -> System.out.println("current: " + n)) // print the "current element"
			.filter(n -> n % 2 == 0)
			.peek(n -> System.out.println("after filter: " + n)) // print the "current element", after apply the filter "n % 2 == 0"
			.forEach(System.out::println);
	}

	private static StringBuilder stringBuilderConverter(Integer e) {
		StringBuilder sb = new StringBuilder();
		sb.append(e);
		sb.append("s");
		sb.append("a");
		return sb;
	}
}
