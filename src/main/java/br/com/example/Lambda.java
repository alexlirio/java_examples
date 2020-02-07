package br.com.example;

import java.util.ArrayList;
import java.util.List;

public class Lambda {

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

}