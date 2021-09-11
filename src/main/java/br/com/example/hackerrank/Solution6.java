package br.com.example.hackerrank;

import java.io.IOException;

public class Solution6 {
    
    // Complete the compareTriplets function below.
	static int[] reverseArray(int[] a) {
        int[] r = new int[a.length];
        int position = 0;
		for (int i = a.length; i > 0; i--) {
			r[position] = a[i-1];
			position += 1;
		}
	    return r;
    }

    public static void main(String[] args) throws IOException {
    	int[] arr = new int[]{1,4,3,2}; 
        System.out.println(reverseArray(arr));
    }
}
