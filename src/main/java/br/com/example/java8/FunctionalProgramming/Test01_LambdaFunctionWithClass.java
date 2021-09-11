package br.com.example.java8.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Test01_LambdaFunctionWithClass {

	public static void main(String[] args) {
		
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("monkey", 5));
		animals.add(new Animal("cat", 15));
		animals.add(new Animal("dog", 10));
		
		// For Tradicional
		for (Animal animal : animals) {
			System.out.println(animal.name);
		}
		
		
		// LAMBDA EXAMPLES BELOW
		
		// Lambda Sort example
		animals.sort((a1, a2) -> Integer.compare(a1.age, a2.age));
		
		// Lambda remove example
		animals.removeIf( a -> a.age < 10);
		
		// Lambda forEach example - Complete
		animals.forEach((Animal a) -> {
			System.out.println(a.name);
			System.out.println(a.age);
		});
		
		// Lambda forEach example - Resumed
		animals.forEach( a -> {
			System.out.println(a.name);
			System.out.println(a.age);
		});
		
		// Lambda forEach example - More Resumed
		animals.forEach( a -> System.out.println(a.name));
		
		// Lambda forEach example to populate a list
		List<Animal> animalList = Arrays.asList(new Animal("monkey", 5), new Animal("cat", 15), new Animal("dog", 10));
		List<String> names = new ArrayList<>();
		animalList.forEach(a -> names.add(a.getName()));
		System.out.println(names);
		
		// Predicare test use example
		Predicate<Integer> pair = (Integer i) -> i % 2 == 0;
		System.out.println(pair.test(10));
		
		// IntPredicare test use example. The primitive type save CPU processing.
		IntPredicate odd = (int i) -> i % 2 != 0;
		System.out.println(odd.test(10));
	}

}

class Animal {
	
	public String name;
	public Integer age;

	public Animal(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

}