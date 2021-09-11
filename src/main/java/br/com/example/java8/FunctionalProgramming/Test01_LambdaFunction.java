package br.com.example.java8.FunctionalProgramming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Test01_LambdaFunction {

	public static void main(String[] args) {
		
		// Lambda Functions
		
		// Lambda use SAM (Single Abstract Method)
		// SAM is an interface with only one abstract method. It's a "@FunctionalInterface". 
		
		
		// Example 1 - without lambda
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world!");
			}
		}).run();
		
		// Example 1 - with lambda
		new Thread(
			() -> System.out.println("Hello world!") // (parameters) -> {body implementation}
		).run();
		
		
		// Example 2 - without lambda
		JButton jButton = new JButton();
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hello world!");
			}
		});
		
		// Example 2 - with lambda
		JButton jButton2 = new JButton();
		jButton2.addActionListener(
			// (parameters) -> {body implementation}
			e -> {
				System.out.println("Hello world 1!");
				System.out.println("Hello world 2!");
			}
		);
	}
}
