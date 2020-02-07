package br.com.example.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    static String findNumber(List<Integer> arr, int k) {
    	return arr.contains(k) ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
    	
        int k = 6;
        
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);

        System.out.println(findNumber(arr, k));
    }
}
