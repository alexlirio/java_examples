package br.com.example.techinterview;

import java.util.Arrays;

public class MyStackTest {

	public static void main(String args[]) {
		
		MyStack myStack = new MyStack();
		System.out.println(myStack); // print []
		
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);
		
		System.out.println(myStack); // print [1, 2, 3]
		
		myStack.pop();
		
		System.out.println(myStack); // print [1, 2]
		
		myStack.pop();
		myStack.pop();
		myStack.pop(); // if myStack == 0 can't throw a Exception
	}
}

//Java program to implement a stack using an array 
class MyStack {
	private static int queue[];

	MyStack() {
		queue = new int[0];
	}

	void push(int data) {
		int[] newQueue = new int[queue.length + 1];
		for (int i = 0; i < queue.length; i++) {
			newQueue[i] = queue[i];
		}
		newQueue[newQueue.length-1] = data;
		queue = newQueue;
	}
	
	void pop() {
		if (queue.length == 0) {
			queue = new int[0];
			return;
		}
		int[] newQueue = new int[queue.length - 1];
		for (int i = 0; i < queue.length-1; i++) {
			newQueue[i] = queue[i];
		}
		queue = newQueue;
	}

	@Override
	public String toString() {
		return Arrays.toString(queue);
	}
}