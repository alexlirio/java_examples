package br.com.example.hackerrank.solution7;

public class Printer<T> {

    /**
    *    Method Name: printArray
    *    Print each element of the generic array on a new line. Do not return anything.
    *    @param A generic array
    **/
    
    // Write your code here
	public void printArray(T[] objects) {
		for (T object : objects) {
			System.out.println(object);
		}
		
	}

}
