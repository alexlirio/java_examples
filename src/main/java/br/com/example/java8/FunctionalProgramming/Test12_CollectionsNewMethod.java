package br.com.example.java8.FunctionalProgramming;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test12_CollectionsNewMethod {
	
	public static void main(String[] args) throws IOException {

		// Collections New Methods
		
		/*******************************/
		/* with List                   */
		/*******************************/
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		// forEach example
		list.forEach(n -> System.out.println(n));
		System.out.println(list); // print: [1, 2, 3, 4]
		
		// removeIf example
		list.removeIf(n -> n % 2 == 0);
		System.out.println(list); // print: [1, 3]
		
		// replaceAll example
		list.replaceAll(n -> n * 2);
		System.out.println(list); // print: [2, 6]
		
		
		
		/*******************************/
		/* with map                    */
		/*******************************/
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "A");
		map.put(1, "B");
		map.put(2, "C");
		map.put(3, "D");
		
		// forEach example
		map.forEach((k, v) -> System.out.println(k + v));
		System.out.println(map); // print: {0=A, 1=B, 2=C, 3=D}
		
		//compute example
		map.compute(1, (k, v) -> v + v); // in this case modify the value of element "1" with "BB" - you can use a new key to put a new element in map
		System.out.println(map); // print: {0=A, 1=BB, 2=C, 3=D}
		
		map.computeIfAbsent(4, k -> "E"); // in this case add "4=E" because the key is absent
		System.out.println(map); // print: {0=A, 1=BB, 2=C, 3=D, 4=E}
		
		map.computeIfPresent(4, (k, v) -> null); // in this case remove "4=E" because the key is present
		System.out.println(map); // print: {0=A, 1=BB, 2=C, 3=D}
		
		// merge example
		map.merge(3, "!", (v1, v2) -> v1 + v2); // in this case modify the value of element "3" with "D!" - you can use a new key to put a new element in map
		System.out.println(map); // print: {0=A, 1=BB, 2=C, 3=D!}
		
		// replaceAll example
		map.replaceAll((k, v) -> v + "!"); // in this case modify the value of all elements, add "!"
		System.out.println(map); // print: {0=A!, 1=BB!, 2=C!, 3=D!!}
	}
}
