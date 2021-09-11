package br.com.example;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {

	public static void main(String[] args) throws IOException {
		
		int key = 5;
		
		int[] sortedArray = new int[] {6, 1, 2, 3, 4, 5, 6};
		Arrays.sort(sortedArray);
		
		List<Integer> sortedList = Arrays.stream(sortedArray).boxed().collect(Collectors.toList());
		
		// #1 Using Arrays.binarySearch();
		int index1 = Arrays.binarySearch(sortedArray, key);
		System.out.println(index1);

		// #2 Using Collections.binarySearch()
		int index2 = Collections.binarySearch(sortedList, key);
		System.out.println(index2);
		
		int lowIndex = 0;
		int highIndex = sortedArray.length - 1;

		// #3 Iterative Impl
		int index3 = runBinarySearchIteratively(sortedArray, key, lowIndex, highIndex);
		System.out.println(index3);
		
		// #4 Recursive Impl
		int index4 = runBinarySearchIteratively(sortedArray, key, lowIndex, highIndex);
		System.out.println(index4);
		
	}
	
	// Iterative Impl
	/**
	 * The runBinarySearchIteratively method takes a sortedArray, key & the low & high indexes of the sortedArray as arguments.
	 * When the method runs for the first time the low, the first index of the sortedArray, is 0, while the high,
	 * the last index of the sortedArray, is equal to its length – 1.
	 * The middle is the middle index of the sortedArray.
	 * Now the algorithm runs a while loop comparing the key with the array value of the middle index of the sortedArray.
	 * 
	 * @param sortedArray
	 * @param key
	 * @param lowIndex index
	 * @param highIndex index
	 * @return index of the search key
	 */
	public static int runBinarySearchIteratively(int[] sortedArray, int key, int lowIndex, int highIndex) {
		int index = Integer.MAX_VALUE;

		while (lowIndex <= highIndex) {
			int mid = (lowIndex + highIndex) / 2;
			if (sortedArray[mid] < key) {
				lowIndex = mid + 1;
			} else if (sortedArray[mid] > key) {
				highIndex = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}
	
	// Recursive Impl
	/**
	 * The runBinarySearchIteratively method takes a sortedArray, key & the low & high indexes of the sortedArray as arguments.
	 * When the method runs for the first time the low, the first index of the sortedArray, is 0, while the high,
	 * the last index of the sortedArray, is equal to its length – 1.
	 * The middle is the middle index of the sortedArray.
	 * Now the algorithm runs a while loop comparing the key with the array value of the middle index of the sortedArray.
	 * 
	 * @param sortedArray
	 * @param key
	 * @param lowIndex index
	 * @param highIndex index
	 * @return index of the search key
	 */
	public static int runBinarySearchRecursively(int[] sortedArray, int key, int lowIndex, int highIndex) {
		int middle = (lowIndex + highIndex) / 2;

		if (highIndex < lowIndex) {
			return -1;
		}

		if (key == sortedArray[middle]) {
			return middle;
		} else if (key < sortedArray[middle]) {
			return runBinarySearchRecursively(sortedArray, key, lowIndex, middle - 1);
		} else {
			return runBinarySearchRecursively(sortedArray, key, middle + 1, highIndex);
		}
	}

}
