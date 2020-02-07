package br.com.example.hackerrank;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution30 {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
    	Map<Character, Integer> ascii = new HashMap<>(26);
    	
    	int i = 0;
    	for (char c = 'a'; c <= 'z'; c++) {
    		ascii.put(Character.valueOf(c), h[i]);
    		i++;
    	}
    	
    	int highest = 1;
    	for (int j = 0; j < word.length(); j++) {
    		int letterHigh = ascii.get(word.charAt(j));
    		if (letterHigh > highest) {
    			highest = letterHigh;
			}
		}
    	return highest * word.length();
    }

    public static void main(String[] args) throws IOException {
        int[] h = new int[] {1,3,1,3,1,4,1,3,2,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
        String word = "abc";
        System.out.println(designerPdfViewer(h, word));
    }
}
