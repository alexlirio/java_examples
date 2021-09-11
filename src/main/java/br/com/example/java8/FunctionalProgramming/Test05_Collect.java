package br.com.example.java8.FunctionalProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test05_Collect {

	public static void main(String[] args) {
		
		// Collect
		// Transform all element in only one
		// Collect is to work with "mutable" (e.g.: StringBuilder). Don't use with "immutable" (e.g.: String or Number)
		
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		System.out.println(list1); // print: [1, 2, 3, 4, 5, 6]
		
		
		
		/********************************/
		/* Example without "Collectors" */
		/********************************/
		
		//supplier, accumulator, combiner
		Set<Integer> collect1 = list1.stream()
				.collect(
					() -> new HashSet<>(), // supplier (l and l1)
					(l, e) -> l.add(e*2), // accumulator (l2)
					(l1, l2) -> l1.addAll(l2) // combiner
				);
		System.out.println(collect1); // print: [2, 4, 6, 8, 10, 12]
		
		
		
		/********************************/
		/* Examples with "Collectors"   */
		/********************************/
		
		// toList
		List<Integer> c1 = list1.stream()
				.filter(e -> e % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(c1); // print: [2, 4, 6]
		
		// toSet
		Set<Integer> c2 = list1.stream()
				.filter(e -> e % 2 == 0)
				.collect(Collectors.toSet());
		System.out.println(c2); // print: [2, 4, 6]
		
		// toCollection (TreeSet, LinkedList, ArrayDeque, etc)
		Set<Integer> c3 = list1.stream()
				.filter(e -> e % 2 == 0)
				.collect(Collectors.toCollection(() -> new TreeSet<>()));
		System.out.println(c3); // print: [2, 4, 6]
		
		// joining
		String s1 = list1.stream()
				.map(e -> e.toString())
				.collect(Collectors.joining());
		System.out.println(s1); // print: 123456
		
		// joining with delimiter ";"
		String s2 = list1.stream()
				.map(e -> e.toString())
				.collect(Collectors.joining(";"));
		System.out.println(s2); // print: 1;2;3;4;5;6
		
		// averaging (Int, Long or Double)
		Double d1 = list1.stream()
				.collect(Collectors.averagingInt(e -> e.intValue()));
		System.out.println(d1); // print: 3.5
		
		// summing (Int, Long or Double)
		Integer i1 = list1.stream()
				.collect(Collectors.summingInt(e -> e.intValue()));
		System.out.println(i1); // print: 21
		
		// summarizing (Int, Long or Double)
		IntSummaryStatistics stats1 = list1.stream()
				.collect(Collectors.summarizingInt(e -> e.intValue()));
		System.out.println(stats1); // print: IntSummaryStatistics{count=6, sum=21, min=1, average=3,500000, max=6}
		System.out.println(stats1.getAverage()); // print: 3.5
		System.out.println(stats1.getCount()); // print: 6
		System.out.println(stats1.getMax()); // print: 6
		System.out.println(stats1.getMin()); // print: 1
		System.out.println(stats1.getSum()); // print: 21
		
		// counting
		Long c4 = list1.stream()
				.collect(Collectors.counting());
		System.out.println(c4); // print: 6
		
		// max
		Optional<Integer> o1 = list1.stream()
				.collect(Collectors.maxBy(Comparator.naturalOrder())); // using naturalOrder
		System.out.println(o1.get()); // print: 6
		
		// min
		Optional<Integer> o2 = list1.stream()
				.collect(Collectors.minBy(Comparator.naturalOrder())); // using naturalOrder
		System.out.println(o2.get()); // print: 1
		
		// groupingBy
		Map<Integer, List<Integer>> m1 = list1.stream()
				.collect(Collectors.groupingBy(n -> n % 3)); // groupingBy (n % 3)
		System.out.println(m1); // print: {0=[3, 6], 1=[1, 4], 2=[2, 5]}
		
		// partitioningBy (*always use "Boolean", partitions in true and false)
		Map<Boolean, List<Integer>> m2 = list1.stream()
				.collect(Collectors.partitioningBy(n -> n % 3 == 0)); // partitioningBy (n % 3 == 0)
		System.out.println(m2); // print: {false=[1, 2, 4, 5], true=[3, 6]}
		
		// toMap
		Map<Integer, Integer> m3 = list1.stream()
				.collect(Collectors.toMap(
						n -> n, // keyMapper
						n -> n* 2 // valueMapper
					)
				);
		System.out.println(m3); // print: {1=2, 2=4, 3=6, 4=8, 5=10, 6=12}
	}
}
