package br.com.example;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	
	public static void main(String[] args) {
		String s = "ABC";
		System.out.println(stringPermutation(s)); // [ABC, ACB, BAC, BCA, CAB, CBA]
		
		List<String> l = new ArrayList<String>();
		l.add("Alex");
		l.add("Patricia");
		l.add("Maju");
		System.out.println(listPermutation(l)); // [[Alex, Patricia, Maju], [Patricia, Alex, Maju], [Patricia, Maju, Alex], [Alex, Maju, Patricia], [Maju, Alex, Patricia], [Maju, Patricia, Alex]]
		
	}
	
	public static List<List<String>> listPermutation(List<String> list) { 
	    if (list.size() == 0) {
	        List<List<String>> result = new ArrayList<List<String>>();
	        result.add(new ArrayList<String>());
	        return result;
	    }

	    List<List<String>> returnMe = new ArrayList<List<String>>();

	    String firstElement = list.remove(0);

	    List<List<String>> recursiveReturn = listPermutation(list);
	    for (List<String> li : recursiveReturn) {

	        for (int index = 0; index <= li.size(); index++) {
	            List<String> temp = new ArrayList<String>(li);
	            temp.add(index, firstElement);
	            returnMe.add(temp);
	        }

	    }
	    return returnMe;
	}
	
	public static ArrayList<String> stringPermutation(String s) { 
		ArrayList<String> results = new ArrayList<>();
		stringPermutation("", s, results);
		return results;
	}
	
	private static void stringPermutation(String prefix, String suffix, ArrayList<String> results) {
		if (suffix.length() == 0) {
			results.add(prefix);
		} else {
			for (int i = 0; i < suffix.length(); i++) {
				stringPermutation(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i+1, suffix.length()), results);
			}
		}
	}

}