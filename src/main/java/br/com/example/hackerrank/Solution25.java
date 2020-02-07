package br.com.example.hackerrank;

import java.util.Scanner;


public class Solution25 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        
        try {
			System.out.println(Integer.valueOf(S));
		} catch (Exception e) {
			System.out.println("Bad String");
		}
    }
}
