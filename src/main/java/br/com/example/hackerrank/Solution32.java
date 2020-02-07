package br.com.example.hackerrank;

import java.util.Scanner;

public class Solution32 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner scanner = new Scanner(System.in);
    	int n = scanner.nextInt();
    	int[] lines = new int[n];
        
        for (int i = 0; i < n; i++) {
        	lines[i] = scanner.nextInt();
		}
        
        scanner.close();
    	
//        int[] lines = new int[] {12,5,7};
//        int[] lines = new int[] {1};
        
        for (int i : lines) {
        	if (i == 1) {
				System.out.println("Not prime");
				continue;
			}
        	boolean isPrime = true;
        	for(int divisor = 2; divisor <= i / 2; divisor++) {
        	    if (i % divisor == 0) {
        	    	isPrime = false;
        	        break;
        	    }
        	}
        	if (isPrime) {
        		System.out.println("Prime");
			} else {
				System.out.println("Not prime");
			}
		}
    }
}