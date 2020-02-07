package br.com.example.hackerrank.solution2;

public class Solution {
	
    public static void main(String[] args) {
        int[] a = new int[] {1, 2, 5};
        Difference difference = new Difference(a);
        difference.computeDifference();
        System.out.print(difference.maximumDifference);
    }

}
