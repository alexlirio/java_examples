package br.com.example.hackerrank;

import java.util.Scanner;

public class Solution14 {
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        
        
        StringBuffer sb1 = new StringBuffer();
        int len = arr.length - 1;
        for (int i = len; i >= 0; i--) {
        	sb1.append(arr[i] + " ");
		}
        
        System.out.println(sb1.toString().trim());

        scanner.close();
    }

}