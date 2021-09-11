package br.com.example.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    static List<Integer> oddNumbers(int l, int r) {
    	
    	List<Integer> ret = new ArrayList<Integer>();
    	
    	for (int i = l; i <= r; i++) {
    		if (!((i%2)==0)) {
    			ret.add(i);
			}
		}
    	return ret;
    }
    
    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    	
    	int countA = 0;
    	int countB = 0;
    	
    	for (int i = 0; i < a.size(); i++) {
    		int aa = a.get(i);
    		int bb = b.get(i);
    		if (aa > bb) {
    			countA += 1;
			} else if (aa < bb) {
				countB += 1;
			}
		}
    	
    	List<Integer> ret = new ArrayList<>();
    	ret.add(countA);
    	ret.add(countB);
		return ret;
    }

    public static void main(String[] args) throws IOException {
    	
    	List<Integer> a = new ArrayList<>();
    	a.add(5);
    	a.add(6);
    	a.add(7);
    	
    	List<Integer> b = new ArrayList<>();
    	b.add(3);
    	b.add(6);
    	b.add(10);


        System.out.println(compareTriplets(a, b) );
    }
}
