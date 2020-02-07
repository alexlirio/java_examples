package br.com.example.hackerrank;

import java.util.Scanner;

public class Solution21 {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	Integer r = null;
        for (int h = 0; h < arr.length - 2; ++h) {
            for(int l = 0; l < arr[h].length - 2; ++l) {
            	int t = arr[h][l] + arr[h][l+1] + arr[h][l+2]
            					  + arr[h+1][l+1]
            	      + arr[h+2][l] + arr[h+2][l+1] + arr[h+2][l+2];
            	if (r == null || t > r) {
					r = t;
            	}
            }
        }
        return r;
    }

    private static final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        
        
    	Integer r = null;
        for (int h = 0; h < arr.length - 2; ++h) {
            for(int l = 0; l < arr[h].length - 2; ++l) {
            	int t = arr[h][l] + arr[h][l+1] + arr[h][l+2]
            					  + arr[h+1][l+1]
            	      + arr[h+2][l] + arr[h+2][l+1] + arr[h+2][l+2];
            	if (r == null || t > r) {
					r = t;
            	}
            }
        }
        System.out.println(r);
        

        scanner.close();
    }

//        int[][] arr = {
//                {-1, -1, 0, -9, -2, -2}, 
//                {-2, -1, -6, -8, -2, -5}, 
//                {-1, -1, -1, -2, -3, -4},
//                {-1, -9, -2, -4, -4, -5}, 
//                {-7, -3, -3, -2, -9, -9}, 
//                {-1, -3, -1, -2, -4, -5},
//          };
        
//        int[][] arr = {
//                {0, 1, 2, 3, 4, 5}, 
//                {6, 7, 8, 9, 0, 1}, 
//                {2, 3, 4, 5, 6, 7},
//                {8, 9, 0, 1, 2, 3}, 
//                {4, 5, 6, 7, 8, 9}, 
//                {0, 1, 2, 3, 4, 5},
//          };
    	
//        int[][] arr = {
//                {1, 1, 1, 0, 0, 0}, 
//                {0, 1, 0, 0, 0, 0}, 
//                {1, 1, 1, 0, 0, 0},
//                {0, 0, 2, 4, 4, 0}, 
//                {0, 0, 0, 2, 0, 0}, 
//                {0, 0, 1, 2, 4, 0},
//          };
    
}
