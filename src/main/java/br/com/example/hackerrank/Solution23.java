package br.com.example.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution23 {

	// https://www.hackerrank.com/challenges/dynamic-array/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here]
    	
    	List<Integer> r = new ArrayList<>();
    	
//    	int n = n;
    	int q =  queries.size();
    	
        List<Integer>[] sequences = new List[n];
        for (int i = 0; i < n; i++) {
            sequences[i] = new ArrayList<>();
        }
        
        int lastans = 0;
    	
        for (int i = 0; i < q; i++) {
            int t = queries.get(i).get(0);
            int x = queries.get(i).get(1);
            int y = queries.get(i).get(2);
            List<Integer> sequence = sequences[(x^lastans)%n];
            switch (t) {
                case 1:
                    sequence.add(y);
                    break;
                case 2:
                    lastans = sequence.get(y%sequence.size());
                    r.add(lastans);
                    break;
            }
        }
        
        return r;
    	
//    	int lastAnswer = 0;
//    	ArrayList<Integer> s0 = new ArrayList<>();
//    	ArrayList<Integer> s1 = new ArrayList<>();
//    	
//    	int q =  queries.size();
//		for (int i = 0; i < q; i++) {
//			
//			int x = queries.get(i).get(1);
//			int y = queries.get(i).get(2);
//			
//			int sX = ((x ^ lastAnswer) % n);
//			if (sX == 0) {
//				s0.add(y);
//			} else if (sX == 1) {
//				s1.add(y);
//			} else {
//				System.out.println("Something wrong!");
//			}
//			
//			lastAnswer = y % q;
//			
//			System.out.println(i+1);
//			System.out.println("s0: " + s0);
//			System.out.println("s1: " + s1);
//			System.out.println("lastAnswer: " + lastAnswer);
//			System.out.println("");
//		}
//    	
//    	
////    	return null;
////		return new ArrayList<Integer>(Arrays.asList(7, 3));
//		return new ArrayList<Integer>(Arrays.asList(s1.get(s1.size()-2), s0.get(s0.size()-2)));

    }

    public static void main(String[] args) throws IOException {
    	
    	int n = 2;
//    	int q = 5;
    	List<List<Integer>> queries = new ArrayList<>();
    	queries.add(0, new ArrayList<Integer>(Arrays.asList(1, 0, 5)));
    	queries.add(1, new ArrayList<Integer>(Arrays.asList(1, 1, 7)));
    	queries.add(2, new ArrayList<Integer>(Arrays.asList(1, 0, 3)));
    	queries.add(3, new ArrayList<Integer>(Arrays.asList(2, 1, 0)));
    	queries.add(4, new ArrayList<Integer>(Arrays.asList(2, 1, 1)));
        System.out.println(dynamicArray(n, queries));
    }
}
