package br.com.example.hackerrank;

import java.io.IOException;

public class Solution22 {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
    	
    	int rA = 0;
    	if (z > x) {
    		rA = z - x;
		} else {
			rA = x - z;
		}
    	
    	int rB = 0;
    	if (z > y) {
    		rB = z - y;
		} else {
			rB = y - z;
		}
    	
    	if (rA < rB) {
			return "Cat A";
		} else if (rB < rA) {
			return "Cat B";
		} else {
			return "Mouse C";
		}

    }

    public static void main(String[] args) throws IOException {
        System.out.println(catAndMouse(1, 2, 3));
        System.out.println(catAndMouse(1, 3, 2));
    }
}
