package br.com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	
	public static void main(String[] args) throws IOException {
		String s = "natan";
		System.out.println(isPalindrome(s));
	}

	/**
	 * 
	 * @param s
	 * @return a boolean true if the string is a palindrome with no matter sort.
	 */
	public static boolean isPalindrome(String s) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.toCharArray()[i]);
			if (list.contains(c)) {
				list.remove(String.valueOf(c));
			} else {
				list.add(String.valueOf(c));
			}
		}
		return list.size() <= 1;
	}

}
