package br.com.example.hackerrank;

import java.io.IOException;

public class Solution37 {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
    	int r = 0;
    	for (int d = i; d <= j; d++) {
    		if (((d - Integer.valueOf(new StringBuilder(String.valueOf(d)).reverse().toString())) % k) == 0) {
    			r++;
    		}
		}
    	return r;
    }

    public static void main(String[] args) throws IOException {
        int i = 20;
        int j = 23;
        int k = 6;
        System.out.println(beautifulDays(i, j, k));
    }
}