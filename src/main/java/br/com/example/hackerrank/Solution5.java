package br.com.example.hackerrank;

import java.io.IOException;

public class Solution5 {
    
    // Complete the compareTriplets function below.
    static long aVeryBigSum(long[] ar) {
    	
	    	long r = 0;
	    	
	    	for (long l : ar) {
				r += l;
			}
	    	
	    	return r;
    }

    public static void main(String[] args) throws IOException {
    	
    	long[] ar = new long[]{1L,2L,3L,4L,5L,6L,7L,8L,9L,10L}; 


        System.out.println(aVeryBigSum(ar));
    }
}
