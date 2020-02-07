package br.com.example.hackerrank;

import java.util.Scanner;

public class Solution13 {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
        String[] lines;
    	
        int n = scanner.nextInt();
        
        lines = new String[n];
        
        for (int i = 0; i < n; i++) {
        	lines[i] = scanner.next();
		}
        
        for (String s : lines) {
        	
        	StringBuffer sb1 = new StringBuffer();
        	StringBuffer sb2 = new StringBuffer();
        	
        	char[] stringToCharArray = s.toCharArray();
        	for (int i = 0; i < stringToCharArray.length; i++) {
        		if (i%2==0) {
					sb1.append(stringToCharArray[i]);
				} else {
					sb2.append(stringToCharArray[i]);
				}
			}
        	
        	System.out.println(sb1.toString() + " " + sb2.toString());
		}

        scanner.close();
    }
}