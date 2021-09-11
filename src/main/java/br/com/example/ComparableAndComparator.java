package br.com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableAndComparator {

	public static void main(String[] args) {
		
		/**************************************************************
		 * Differences
		 * 
		 * Comparable Interface
		 * 1. Sort order: Default/Natural
		 * 2. Package: java.lang
		 * 3. Method(s): compareTo()
		 * 4. Classes that implement: all wrapper classes and String
		 * 
		 * Comparator Interface
		 * 1. Sort order: Customized
		 * 2. Package: java.util
		 * 3. Method(s): compare() and equals()
		 * 4. Classes that implement: Collator and RuleBasedCollator
		 *
		 **************************************************************/
		
        //#1 Comparable - Example with Comparable Interface Implementation (*Sorting by "age")
        List<PlayerComparable> playersComparable = Arrays.asList(new PlayerComparable("Beth", 20), new PlayerComparable("Alex", 30), new PlayerComparable("Carl", 10));
        System.out.println("#1 Before Sorting: " + playersComparable);
        Collections.sort(playersComparable);
        System.out.println("#1 After Sorting:  " + playersComparable);
        
        
        
        // #1 Comparator - Example with Comparator Interface Implementation (*Sorting by "name")
        List<PlayerComparator> playersComparator = Arrays.asList(new PlayerComparator("Beth", 20), new PlayerComparator("Alex", 30), new PlayerComparator("Carl", 10));
        System.out.println("#1 Before Sorting: " + playersComparator);
        playersComparator.sort(new PlayerComparator()); // #1
        System.out.println("#1 After Sorting:  " + playersComparator);
        
        // #2 Comparator - Example with Comparator Interface Implementation (*Sorting by "name")
        List<PlayerComparator> playersComparator2 = Arrays.asList(new PlayerComparator("Beth", 20), new PlayerComparator("Alex", 30), new PlayerComparator("Carl", 10));
        System.out.println("#2 Before Sorting: " + playersComparator2);
        Collections.sort(playersComparator2, new PlayerComparator()); // #2
        System.out.println("#2 After Sorting:  " + playersComparator2);
        
        
        // #3 Comparator - Example with new Comparator Implementation (*Sorting by "name")
        List<Player> players = Arrays.asList(new Player("Beth", 20), new Player("Alex", 30), new Player("Carl", 10));
        System.out.println("#3 Before Sorting: " + players);
        Collections.sort(
                    players,
                    new Comparator<Player>() {
                        @Override
                        public int compare(Player o1, Player o2) {
                            return o1.getName().compareTo(o2.getName());
                        }
                    }
                );  // #3
        System.out.println("#3 After Sorting:  " + players);
        
        // #4 Comparator - Example with Lambda (*Sorting by "name")
        List<Player> players2 = Arrays.asList(new Player("Beth", 20), new Player("Alex", 30), new Player("Carl", 10));
        System.out.println("#4 Before Sorting: " + players2);
        players.sort((o1, o2) -> o1.getName().compareTo(o2.getName())); // #4
        System.out.println("#4 After Sorting:  " + players2);
	}
}

class PlayerComparable implements Comparable<PlayerComparable> {
	private String name;
	private int age;
	
	public PlayerComparable(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compareTo(PlayerComparable otherPlayer) {
		return Integer.compare(this.getAge(), otherPlayer.getAge());
	}
	
	@Override
	public String toString() {
		return "PlayerComparable [name=" + name + ", age=" + age + "]";
	}
}

class PlayerComparator implements Comparator<PlayerComparator> {
	private String name;
    private int age;
    
    public PlayerComparator() {
		super();
	}

	public PlayerComparator(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public int compare(PlayerComparator o1, PlayerComparator o2) {
		return o1.getName().compareTo(o2.getName());
	}

	@Override
	public String toString() {
		return "PlayerComparator [name=" + name + ", age=" + age + "]";
	}
}

class Player {
	private String name;
	private int age;
	
	public Player(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + "]";
	}
}
