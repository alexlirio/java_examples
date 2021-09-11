package br.com.example.hackerrank.solution3;

public class MyBook extends Book {
	
	private int price;

	public MyBook(String title, String author, int price) {
		super(title, author);
		this.price = price;
	}

	@Override
	public void display() {
		System.out.println("Title: " + this.title);
		System.out.println("Author: " + this.author);
		System.out.println("Price: " + this.price);
	}
	
}