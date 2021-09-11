package br.com.example.java8.FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author alirio
 * 
 * Table 7.1 - Stream sources and decomposability
 * Source			|	Decomposability
 * ArrayList		|	Excellent
 * LinkedList		|	Poor
 * IntStream.range	|	Excellent
 * Stream.iterate	|	Poor
 * HashSet			|	Good
 * TreeSet			|	Good
 *
 */
public class Test02_StreamWithClass {

	public static void main(String[] args) {
		////example 1 - object String[]
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("John", 10, Gender.MALE));
		personList.add(new Person("Alex", 15, Gender.MALE));
		personList.add(new Person("Alex", 12, Gender.FEMALE));
		personList.add(new Person("George", 17, Gender.MALE));
		personList.add(new Person("Mary", 13, Gender.FEMALE));
		personList.add(new Person("Marie", 20, Gender.FEMALE));
		
		//stream example 1 (.map to return the final do you want Stream<String>)
		List<String> nameList1 = personList.stream()
				.filter(p -> p.getAge() < 18) //filter by age < 18
				.sorted(Comparator.comparing(Person::getName)) //sort by name
				.skip(1) // skip 1
				.limit(4) // limit 4
				.map(Person::getName) //return Stream<String> = 'java.util.stream.ReferencePipeline$3@16ec8df'
				.distinct() //distinct 
				.collect(Collectors.toList());//return List<String> = '[Alex, George, John, Mary]'
		System.out.println(nameList1);
		
		
		//partitioningBy example
		Map<Boolean, List<Person>> collect = personList.stream().collect(Collectors.partitioningBy(p -> p.getName().equalsIgnoreCase("Alex")));
		System.out.println(collect.get(true)); //[Person [name=Alex], Person [name=Alex]]
		System.out.println(collect.get(false)); //[Person [name=John], Person [name=George], Person [name=Mary], Person [name=Marie]]
		
		
		//println each element of the list
		nameList1.stream().forEach(System.out::println);
		
		
		////example 2 - object String[][]
		List<List<String>> personListList = new ArrayList<>();
		personListList.add(Arrays.asList("John", "Toronto"));
		personListList.add(Arrays.asList("Alex", "Rio de Janeiro"));
		
		//stream example 2 (.flatMap to return Stream<Object> yet)
		List<String> nameList2 = personListList.stream()
				.flatMap(Collection::stream) //return Stream<Object> = 'java.util.stream.ReferencePipeline$7@1846d2c'
				.collect(Collectors.toList());//return List<String> = '[John, Toronto, Alex, Rio de Janeiro]'
		System.out.println(nameList2);
		
		
		////example 3 - object map<gender, person[]>
		
		//group by gender (old way - java 7)
		Map<Gender, List<Person>> genderMap1 = new HashMap<>();
		List<Person> maleList = new ArrayList<>();
		List<Person> femaleList = new ArrayList<>();
		for (Person person : personList) {
			if (person.getGender().equals(Gender.MALE))
				maleList.add(person);
			else
				femaleList.add(person);
		}
		genderMap1.put(Gender.MALE, maleList);
		genderMap1.put(Gender.FEMALE, femaleList);
		System.out.println(genderMap1); //{MALE=[Person [name=John], Person [name=Alex], Person [name=George]], FEMALE=[Person [name=Alex], Person [name=Mary], Person [name=Marie]]}
		
		//group by gender
		Map<Gender, List<Person>> genderMap2 = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		System.out.println(genderMap2); //{MALE=[Person [name=John], Person [name=Alex], Person [name=George]], FEMALE=[Person [name=Alex], Person [name=Mary], Person [name=Marie]]}
		
		//group by majority
		Map<String, List<Person>> majorityMap1 = personList.stream()
				.collect(Collectors.groupingBy(p -> {
					if (p.getAge() < 18) {
						return "Under Age";
					} else {
						return "Of Age";
					}
				}));
		System.out.println(majorityMap1); //{Of Age=[Person [name=Marie]], Under Age=[Person [name=John], Person [name=Alex], Person [name=Alex], Person [name=George], Person [name=Mary]]}
		
		//group by gender and majority
		Map<Gender, Map<String, List<Person>>> genderAndMajorityMap1 = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.groupingBy(p -> {
					if (p.getAge() < 18) {
						return "Under Age";
					} else {
						return "Of Age";
					}
				})));
		System.out.println(genderAndMajorityMap1); //{MALE={Under Age=[Person [name=John], Person [name=Alex], Person [name=George]]}, FEMALE={Of Age=[Person [name=Marie]], Under Age=[Person [name=Alex], Person [name=Mary]]}}
		
		//group by gender and count
		Map<Gender, Long> genderAndCountMap1 = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		System.out.println(genderAndCountMap1); //{MALE=3, FEMALE=3}
		
		//group by gender and biggest age
		Map<Gender, Person> genderAndBiggestAgeMap1 = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Person::getAge)), Optional::get
				)));
		System.out.println(genderAndBiggestAgeMap1); //{MALE=Person [name=George], FEMALE=Person [name=Marie]}
		
		//group by gender and IntSummaryStatistics (Choose one: IntSummaryStatistics, LongSummaryStatistics or DoubleSummaryStatistics)
		//SummaryStatistics fields are: count, sum2, min, average and max
		Map<Gender, IntSummaryStatistics> genderAndDoubleSummaryStatisticsMap1 = personList.stream()
				.collect(Collectors.groupingBy(Person::getGender, Collectors.summarizingInt(Person::getAge)));
		System.out.println(genderAndDoubleSummaryStatisticsMap1); //{MALE=IntSummaryStatistics{count=3, sum=42, min=10, average=14,000000, max=17}, FEMALE=IntSummaryStatistics{count=3, sum=45, min=12, average=15,000000, max=20}}
		
		
		////example 4 - int iterate example and performance speed
		
		//for iterate over array (faster - use one CPU core only)
		long maxSize = 10000000L;
		long result = 0;
		long init = System.currentTimeMillis();
		for (int i = 0; i <= maxSize; i++) {
			result += i;
		}
		long end = System.currentTimeMillis();
		System.out.println("For(with iterate over array) Result: sum " + result + " in " + (end - init) + "ms"); //For(with iterate over array) Result: sum 55 in 0ms
		
		//sequential stream (use one CPU core only)
		maxSize = 10000000L;
		result = 0;
		init = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(maxSize).reduce(0L, Long::sum);
		end = System.currentTimeMillis();
		System.out.println("Sequential Stream Result: sum " + result + " in " + (end - init) + "ms"); //Sequential Stream Result: sum 55 in 1ms
		
		//parallel stream (slow - use more than one CPU core - divide the CPU processing and merge the result)
		maxSize = 10000000L;
		result = 0;
		init = System.currentTimeMillis();
		result = Stream.iterate(1L, i -> i + 1).limit(maxSize).parallel().reduce(0L, Long::sum);
		end = System.currentTimeMillis();
		System.out.println("Parallel Stream Result: sum " + result + " in " + (end - init) + "ms"); //Parallel Stream Result: sum 55 in 14ms
		
		
		////example 5 - long iterate example and performance speed
		
		//sequential stream (slow - use one CPU core only)
		maxSize = 10000000L;
		result = 0;
		init = System.currentTimeMillis();
		result = LongStream.rangeClosed(1L, maxSize).reduce(0L, Long::sum);
		end = System.currentTimeMillis();
		System.out.println("Range Stream Result: sum " + result + " in " + (end - init) + "ms"); //Parallel Stream Result: sum 55 in 14ms
		
		//parallel stream (faster only with non sequential big arrays/lists - share the work to process in more CPU cores)
		maxSize = 10000000L;
		result = 0;
		init = System.currentTimeMillis();
		result = LongStream.rangeClosed(1L, maxSize).parallel().reduce(0L, Long::sum);
		end = System.currentTimeMillis();
		System.out.println("Range Stream Result: sum " + result + " in " + (end - init) + "ms"); //Parallel Stream Result: sum 55 in 14ms
	}
}

class Person {
	public String name;
	public Integer age;
	public Gender gender;

	public Person(String name, Integer age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public Gender getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}

enum Gender {
	MALE,
	FEMALE
}
