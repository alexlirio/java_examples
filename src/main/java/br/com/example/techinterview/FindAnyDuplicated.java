package br.com.example.techinterview;

import java.util.HashSet;

public class FindAnyDuplicated {

	public static void main(String[] args) {
		int[] intArray = new int[]{5, 1, 2, 3, 4, 5};
		System.out.println(findAnyDuplicate(intArray));
	}

	/**
	 * @param intArray
	 * @return an duplicate element in intArray. Return -1 if there aren't any duplicate element.
	 */
	private static int findAnyDuplicate(int[] intArray) {
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i : intArray) {
			if (hashSet.contains(i)) {
				return i;
			} else {
				hashSet.add(i);
				continue;
			}
		}
		return -1; 
	}

}
