package br.com.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorAndComparable {

	public static void main(String[] args) {
		//#1 Comparator - Example with Lambda (*Sorting by "name")
		List<Player> players = Arrays.asList(new Player("Beth", 20), new Player("Alex", 30), new Player("Carl", 10));
	    System.out.println("Before Sorting: " + players);
	    players.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
	    System.out.println("After Sorting:  " + players);

		//#2 Comparator - Example with Comparator Interface Implementation (*Sorting by "name")
	    List<PlayerComparator> playersComparator = Arrays.asList(new PlayerComparator("Beth", 20), new PlayerComparator("Alex", 30), new PlayerComparator("Carl", 10));
	    System.out.println("Before Sorting: " + playersComparator);
	    playersComparator.sort(new PlayerComparator());
	    System.out.println("After Sorting:  " + playersComparator);

	    //#2 Comparable - Example with Comparable Interface Implementation (*Sorting by "age")
	    List<PlayerComparable> playersComparable = Arrays.asList(new PlayerComparable("Beth", 20), new PlayerComparable("Alex", 30), new PlayerComparable("Carl", 10));
	    System.out.println("Before Sorting: " + playersComparable);
	    Collections.sort(playersComparable);
	    System.out.println("After Sorting:  " + playersComparable);
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
