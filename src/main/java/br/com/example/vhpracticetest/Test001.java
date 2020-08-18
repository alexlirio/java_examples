package br.com.example.vhpracticetest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test001 {
	
	static String parameter = "label"; 
	static int maxSize = 48; 
	
	// polindrome with no matter sort
	public static void main(String[] args) throws IOException {
		
		String word = "nata";
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < word.length(); i++) {
			String c = String.valueOf(word.toCharArray()[i]);
			if (list.contains(c)) {
				list.remove(String.valueOf(c));
			} else {
				list.add(String.valueOf(c));
			}
		}
		
		System.out.println(list.size() <= 1);
	}

}
