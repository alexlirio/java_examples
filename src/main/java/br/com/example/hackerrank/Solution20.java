package br.com.example.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution20 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = Integer.toBinaryString(n);
        
        List<Integer> tList = new ArrayList<Integer>();
        int t = 0;
    	for (int i = 0; i < s.length(); i++) {
			if (s.toCharArray()[i] == '1') {
				t += 1;
			} else {
				tList.add(t);
				t = 0;
			}
		}
    	
    	tList.add(t);
        
    	int r = 0;
    	for (Integer i : tList) {
			if (i >= r) {
				r = i;
			}
		}
    	
    	System.out.println(r);
        
        scanner.close();
    }
}
