package br.com.example;

import java.util.Arrays;

/**
 * 
 * @author alirio
 * 
 * Some BigO examples:
 * 1. O(1) - Constant time
 * 2. O(n) - Linear time
 * 3. O(n2) - Quadratic time
 * 4. O(log n) - Logarithmic time
 */
public class BigO {
	
	public static void main(String[] args) {
		int myArray[] = { 10, 6, 5, 4, 11, 7 };
		
		System.out.println("Input: " + Arrays.toString(myArray));
		System.out.println();
		
		
		//1. O(1) - Constant Time
		System.out.println("1. O(1) - Constant Time");
		System.out.println("myArray[2] = " + myArray[2]);
		System.out.println();
		
		
		//2. O(n) - Linear Time
		System.out.println("2. O(n) - Linear Time");
		for (int i = 0; i < myArray.length; i++) {
			System.out.print(myArray[i] + ", ");
		}
		System.out.println("\n");
		
		
		//3. O(n^2) - Quadratic Time
		//Bubble sort example:
		//1. sort comparing each element with every other element
		System.out.println("3. O(n^2) - Quadratic Time (e.g.: Bubble sort)");
		for (int i = 0; i < myArray.length; i++) {
			for (int j = 1; j < (myArray.length - i); j++) {
				if (myArray[j - 1] > myArray[j]) {
					// Swap
					int temp = myArray[j - 1];
					myArray[j - 1] = myArray[j];
					myArray[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(myArray));
		System.out.println();
		
		
		//4. O(log n) - Logarithmic Time
		//Binary search example:
		//1. Take the middle element of the array
		//2. Compare with element 'e'
		//3. If middle element is equal to 'e' - We found the element
		//4. else if 'e' is less than middle element, The element we are looking for is in the lower half of the array - So search lower half
		//5. else 'e' is greater than middle element, The element we are looking for is in the upper half of the array - So search upper half
		// Important: Java has "Arrays.binarySearch()" and "Collections.binarySearch()".
		System.out.println("4. O(log n) - Logarithmic Time (e.g.: Binary search)");
		Arrays.sort(myArray); // Need to sort the array before
		System.out.println("index of element 6 = " + binarySearch(myArray, 6, 0, myArray.length - 1));
		System.out.println();
	}

	static int binarySearch(int[] array, int value, int left, int right) {
		if (left > right)
			return -1;
		int middle = (left + right) / 2;
		if (array[middle] == value) {
			return middle;
		} else if (array[middle] > value) {
			return binarySearch(array, value, left, middle - 1);
		} else {
			return binarySearch(array, value, middle + 1, right);
		}
	}
}
