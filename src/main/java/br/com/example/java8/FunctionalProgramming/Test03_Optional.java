package br.com.example.java8.FunctionalProgramming;

import java.util.Optional;
import java.util.OptionalInt;

public class Test03_Optional {

	public static void main(String[] args) {
		
		// Optional
		
		// Optional is used to the return of method. Methods than can return a optional value.
		// Don't create method with Optional argument. Use/Create a method overload, without the Optional argument.
		
		System.out.println(Optional.ofNullable("abc").orElse(null)); // print 'abc'
		
		String n = null;
		System.out.println(Optional.ofNullable(n).orElse(null)); // print null
		
		System.out.println("---");
		
		String s1 = null;
//		Optional<String> o1 = Optional.of(s1); // throw a NumberFormatException - use "ofNullable" istead of "of"
		Optional<String> o2 = Optional.ofNullable(s1);
		System.out.println(o2); // print: Optional.empty
		
		
		System.out.println("\nNot Optional.empty examples:");
		
		String s2 = "1";
		Optional<Integer> i1 = convertToInteger(s2);
		System.out.println(i1); // print: Optional[1]
		System.out.println(i1.get()); // print: 1 (if "Optional.empty" throw a NoSuchElementException)
		System.out.println(i1.isPresent()); // print: true
		i1.ifPresent(e -> System.out.println(e)); // print: 1
		
		
		System.out.println("\nOptional.empty examples:");
		
		Optional<Integer> i2 = Optional.empty();
		System.out.println(i2.orElse(2)); // print: 2 
		System.out.println(i2.orElseGet(() -> convertToInteger("5").get())); // return: 5
//		System.out.println(i2.orElseThrow(() -> new NullPointerException("The value is NULL"))); // throw a NullPointerException
		
		
		System.out.println("\nOptional with primitive types (e.g.: int):");
		
		String s3 = "1";
		int i3 = convertToInt(s3).orElse(2); // return: 1 (return "int" primitive type instead of "Optional")
		System.out.println(i3); // print: 1
		
	}
	
	private static Optional<Integer> convertToInteger(String s) {
		try {
			Integer i = Integer.valueOf(s); // can throw a NumberFormatException
			return Optional.of(i);
		} catch (Exception e) {
			return Optional.empty(); // Optional.empty
		}
	}
	
	// Optional of primitive type - in this case is "int"
	public static OptionalInt convertToInt(String s) {
		try {
			Integer i = Integer.valueOf(s);
			return OptionalInt.of(i);
		} catch (Exception e) {
			return OptionalInt.empty();
		}
	}
}
