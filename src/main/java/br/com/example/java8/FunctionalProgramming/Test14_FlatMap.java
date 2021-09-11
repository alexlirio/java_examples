package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test14_FlatMap {

	public static void main(String[] args) {
		
		// flatMap
		// flatMap basically merge all the objects in to one. [1,2][1,1] -> [1,2,1,1]
		// With flatMap: [1,2][1,1] -> [1,2,1,1]
		// With map:     [1,2][1,1] -> [[1,2][1,1]]

		Map<String, List<String>> peopleWithPhonesMap = new HashMap<>(); // String[][]
		peopleWithPhonesMap.put("Alex", Arrays.asList("999-9999-999","888-8888-888"));
		peopleWithPhonesMap.put("Patricia", Arrays.asList("777-7777-777","666-6666-666"));
		peopleWithPhonesMap.put("Maju", Arrays.asList("555-5555-555","444-4444-444"));
		
		// flatMap Stream to get all phones - e.g.: [1,2][1,1] -> [1,2,1,1]
		List<String> phoneList1 = peopleWithPhonesMap.values().stream()
				.flatMap(Collection::stream)
				.collect(Collectors.toList());
		
		for (String phone : phoneList1) {
			System.out.println(phone);
		}
		System.out.println("---------------------");
		
		// map Stream to get all phones - e.g.: [1,2][1,1] -> [[1,2][1,1]]
		List<Stream<String>> phoneList2 = peopleWithPhonesMap.values().stream()
				.map(Collection::stream)
				.collect(Collectors.toList());
		
		for (Stream<String> phoneStream : phoneList2) {
			List<String> phoneList = phoneStream.collect(Collectors.toList());
			System.out.println(phoneList);
		}
		System.out.println("---------------------");
	}
}
