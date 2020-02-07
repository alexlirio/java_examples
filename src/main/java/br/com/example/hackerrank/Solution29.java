package br.com.example.hackerrank;

import java.io.IOException;

public class Solution29 {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
    	int[] r = new int[queries.length];
    	for (int i = 0; i < queries.length; i++) {
    		int count = 0;
    		for (String s : strings) {
				if (queries[i].equalsIgnoreCase(s)) {
					count++;
				}
			}
    		r[i] = count;
		}
    	return r;
    }

    public static void main(String[] args) throws IOException {
        String[] strings = new String[] {"aba", "baba", "aba", "xzxb"};
        String[] queries = new String[] {"aba", "xzxb", "ab"};
        System.out.println(matchingStrings(strings, queries));
    }
}