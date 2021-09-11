package br.com.example.hackerrank;

public class Solution28 {

    public static void main(String[] args) {
        int n = 3;
//        int[] a = new int[] {1, 2, 3};
        int[] a = new int[] {3, 2, 1};
        
        // Write Your Code Here
        int numberOfSwapsToReturn = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;
            
            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
//                    swap(a[j], a[j + 1]);
                	int t1 = a[j];
                	int t2 = a[j + 1];
                	a[j] = t2;
                	a[j + 1] = t1;
                    numberOfSwaps++;
                    numberOfSwapsToReturn++;
                }
            }
            
            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            }
        }
        System.out.println("Array is sorted in " + numberOfSwapsToReturn + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);
    }

}
