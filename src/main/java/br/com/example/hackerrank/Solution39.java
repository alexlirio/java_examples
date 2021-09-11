package br.com.example.hackerrank;

public class Solution39 {

    public static void main(String[] args) {
//        int t = 3;
        int n = 5;
        int k = 2;
//        int n = 8;
//        int k = 5;
//        int n = 2;
//        int k = 2;
        
        // My solution
//      int r = 0;
//      for (int a = 1; a < n; a++) {
//      	for (int b = 2; b <= n; b++) {
//      		int aeb = (a & b);
//      		if (r < aeb && aeb < k ) {
//      			r = aeb;
//      		}
//			}
//		}
//      System.out.println(r);
        
        // Solution from chat
		if (((k - 1) | k) > n && k % 2 == 0) {
			System.out.println(k - 2);
		} else {
			System.out.println(k - 1);
		}
    }
}