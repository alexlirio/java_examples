package br.com.example.hackerrank;

import java.util.LinkedList;

public class Solution24 {

    public static void main(String[] args) {
		int d = 4;
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		
		int[] b = leftRotation(d, a);
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			s.append(b[i] + " ");
		}
		System.out.print(s.substring(0, s.length()-1) );
    }
    
    private static int[] leftRotation(int d, int[] a) {
    	LinkedList<Integer> ll = new LinkedList<>();
    	for (int i = 0; i < a.length; i++) {
    		ll.add(a[i]);
		}
    	for (int i = 0; i < d; i++) {
    		ll.addLast(ll.getFirst());
    		ll.removeFirst();
		}
    	int[] r = ll.stream().mapToInt(i -> i).toArray();
    	return r;
    }
    
    
}
