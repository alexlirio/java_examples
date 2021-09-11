package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test02_Stream {

	public static void main(String[] args) {
		
		// Stream
		
		// Streams: use implicit loops - the java will choose the better loop will be used 
		// For / while / do while: use explicit loops - you will write which loop will be used
		
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5);
		
		
		System.out.println("Example 1 - without stream:");
		
		// Example 1 - without stream
		for (Integer e : list) {
			System.out.println(e);
		}
		
		
		System.out.println("\nExample 1 - with stream:");
		
		// Example 1 - with stream
		list.stream().forEach(e -> System.out.println(e));
		
		
		System.out.println("\nIntermediate Operations Examples:");
		
		// Intermediate Operations Examples
		// 1. the original "list" won't change with the operations
		// 2. can use various "intermediate operation"
		// 3. can use only one "terminal operation"
		list.stream()
			.skip(2) // intermediate operation (*skip the x first elements)
			.limit(2) // intermediate operation (*limit the x elements)
			.distinct() // intermediate operation (*distinct use equals and hashcode methods)
			.filter(e -> e %2 == 0) // intermediate operation (*filter the elements - in this case will pass only pair numbers)
			.map(e -> e * 2) // intermediate operation (*map transform the element in another - in this case will multiply the element by two)
			.forEach(e -> System.out.println(e)); // terminal operation
		
		
		System.out.println("\nTerminal Operations Examples:");
		
		// Terminal Operations Examples
		long count = list.stream()
				.count(); // terminal operation (*count return a long with the count elements of stream)
		System.out.println(count);
		
		Optional<Integer> min = list.stream()
				.min(Comparator.naturalOrder()); // terminal operation (*min return the min value of stream)
		System.out.println(min.get());
		
		Optional<Integer> max = list.stream()
				.max(Comparator.naturalOrder()); // terminal operation (*max return the max value of stream)
		System.out.println(max.get());
		
		List<Integer> collect = list.stream()
				.distinct()
				.collect(Collectors.toList()); // terminal operation (*collect toList return a new Collection - in this case will return a new List)
		System.out.println(collect);
		
		Map<Boolean, List<Integer>> map = list.stream()
				.distinct()
				.collect(Collectors.groupingBy(e -> e % 2 == 0)); // terminal operation (*collect groupingBy return a new Collection grouped - in this case will return a new MapMap<"return_type", List<"type">> grouped by odd and even)
		System.out.println(map);
		
		String str = list.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining()); // terminal operation (*collect joining return a new String concatenate)
		System.out.println(str);
		
		String str2 = list.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining(";")); // terminal operation (*collect joining return a new String concatenate - in this case will return a new String concatenate with ";")
		System.out.println(str2);
		
		
		System.out.println("\nParallel Stream - to use more than one CPU:");
		
		// Parallel Stream Example - to use more than one CPU
		long count2 = list.parallelStream()
				.count(); // terminal operation (*count return a long with the count elements of stream)
		System.out.println(count2);
	}
}
