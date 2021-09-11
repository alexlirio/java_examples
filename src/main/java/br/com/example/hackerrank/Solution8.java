package br.com.example.hackerrank;

import java.io.IOException;
import java.util.Arrays;

public class Solution8 {

    static int sockMerchant(int n, int[] ar) {
    	int r = 0;
    	Arrays.sort(ar);
    	int previous = -1;
    	for (int i = 0; i < n; i++) { //[10, 10, 10, 10, 20, 20, 20, 30, 50]
    		int current = ar[i];
    		if (previous == current) {
				r += 1;
				previous = -1;
			} else {
				previous = current;
			}
		}
		return r;
    }

    public static void main(String[] args) throws IOException {
        int n = 9;
        int[] ar = new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20};
        System.out.println(sockMerchant(n, ar) );
    }
}
