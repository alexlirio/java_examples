package br.com.example.java8.FunctionalProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test11_StreamCreation {
	
	public static void main(String[] args) throws IOException {

		// Stream Creation

		
		// Collection
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
		list.stream().forEach(System.out::println);
		
		// Array
		Integer[] intArray = new Integer[] {1, 2, 3, 4, 5};
		Arrays.stream(intArray).forEach(System.out::println);
		
		// Stream.of - can use all object types - in this case "String"
		Stream
			.of("A", "B", "C", "D", "E")
			.forEach(System.out::println);
		
		// IntStream.range
		IntStream
			.range(0, 5) // use startInclusive and endExclusive - in this case will be "0, 1, 2, 3, 4"
		.forEach(System.out::println);
		
		// IntStream.rangeClosed
		IntStream
			.rangeClosed(0, 5) // use startInclusive and endInclusive - in this case will be "0, 1, 2, 3, 4, 5"
			.forEach(System.out::println);
		
		// Stream.itarage
		Stream
			.iterate(5, n -> n * 2) // iterate - in this case will start with 5 and the next number will multiply 5 by 2 (n * 2). e.g.: 5, 10, ...
			.limit(10) // limit to print 10 lines/times
			.forEach(System.out::println);
		
		// BufferedReader - lines
		File file = new File("src/main/resources/stream.txt");
		FileReader in = new FileReader(file);
		try (BufferedReader br = new BufferedReader(in)) { // Try used here to close the "BufferedReader"
			br.lines()
				.forEach(System.out::println);
		}
		
		// File
		Path path = Paths.get("");
		Files.list(path)
			.forEach(System.out::println);
		
		// Random
		new Random().ints()
			.limit(10) // limit to print 10 lines/times 
			.forEach(System.out::println);
		
		// Pattern
		String s = "Hello World!";
		Pattern p = Pattern.compile(" "); // regex to split
		p.splitAsStream(s)
			.forEach(System.out::println);
	}
}
