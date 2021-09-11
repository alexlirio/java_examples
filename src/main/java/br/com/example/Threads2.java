package br.com.example;

public class Threads2 {

	public static void main(String[] args) {
		System.out.println("Line 1");
		methodOne();
		System.out.println("Line 2");
	}

	public static void methodOne() {
	    int i = 9;
		new Thread() {
			@Override
			public void run() {
				System.out.println(i + "methodOne");
			}
		}.start();
	}

}
