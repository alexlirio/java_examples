package br.com.example.hackerrank;

import java.io.IOException;

public class Solution9 {

    static int countingValleys(int n, String s) {
    	
    	int r = 0;
    	int lastPosition = 0;
    	int position = 0;
    	char[] sArray = s.toCharArray(); 
    	
    	for (int i = 0; i < sArray.length; i++) {
    		char step = sArray[i];
    		if (step == 'D') {
    			lastPosition = position;
				position -= 1;
			} else if (step == 'U') {
				lastPosition = position;
				position += 1;
			}
    		if (lastPosition == 0 && position == -1) {
				r += 1;
			}
		}
		return r;
    }

    public static void main(String[] args) throws IOException {
    	int n = 8;
    	String s = "UDDDUDUU"; //DDUUDDUDUUUD
        System.out.println(countingValleys(n, s));
    }
}
