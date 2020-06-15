package br.com.example;

public class BigO {
	
	public static void main(String[] args) {
		int n = 10000;
		method1(n); //O(1)
		method2(n); //O(log n)
		method3(n); //O(n)
		method4(n); //O(n log n)
		method5(n); //O(n^p)
		method6(n); //O(k^n)
		method7(n); //O(n!)
	}
	
	public static void method1(int n) {
		System.out.println("1. O(1) - Constant Time Algorithms");
		long l = System.currentTimeMillis();
//		System.out.println("Hey - your input is: " + n);
		int t = 1 + 1;
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	public static void method2(int n) {
		System.out.println("2. O(log n) - Logarithmic Time Algorithms");
		long l = System.currentTimeMillis();
		for (int i = 1; i < n; i = i * 2){
//		    System.out.println("Hey - I'm busy looking at: " + i);
			int t = 1 + 1;
		}
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	public static void method3(int n) {
		System.out.println("3. O(n) - Linear Time Algorithms");
		long l = System.currentTimeMillis();
		for (int i = 0; i < n; i++) {
//		    System.out.println("Hey - I'm busy looking at: " + i);
		    int t = 1 + 1;
		}
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	public static void method4(int n) {
		System.out.println("4. O(n log n) - N Log N Time Algorithms");
		long l = System.currentTimeMillis();
		for (int i = 1; i <= n; i++){
		    for(int j = 1; j < 8; j = j * 2) {
//		        System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
		    	int t = 1 + 1;
		    }
		}
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	public static void method5(int n) {
		System.out.println("5. O(n^p) - Polynomial Time Algorithms");
		long l = System.currentTimeMillis();
		for (int i = 1; i <= n; i++) {
		    for(int j = 1; j <= n; j++) {
//		        System.out.println("Hey - I'm busy looking at: " + i + " and " + j);
		    	int t = 1 + 1;
		    }
		}
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	public static void method6(int n) {
		System.out.println("6. O(k^n) - Exponential Time Algorithms");
		long l = System.currentTimeMillis();
		for (int i = 1; i <= Math.pow(2, n); i++){
//		    System.out.println("Hey - I'm busy looking at: " + i);
			int t = 1 + 1;
		}
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	public static void method7(int n) {
		System.out.println("7. O(n!) - Factorial Time Algorithms");
		long l = System.currentTimeMillis();
		for (int i = 1; i <= factorial(n); i++){
//		    System.out.println("Hey - I'm busy looking at: " + i);
			int t = 1 + 1;
		}
		System.out.println("Milliseconds: " + (System.currentTimeMillis() - l) + "\n");
	}
	
	private static long factorial(int n) {
	    long fact = 1;
	    for (int i = 2; i <= n; i++) {
	        fact = fact * i;
	    }
	    return fact;
	}

}
