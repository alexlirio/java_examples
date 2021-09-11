package br.com.example.hackerrank.solution10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

	public static Node removeDuplicates(Node head) {
		// Write your code here
		Map<Integer, Node> m = new HashMap<>();
		
		Node start = head;
		while (start != null) {
			m.put(start.data, start);
			start = start.next;
		}
		
		List<Integer> l = new ArrayList<>(m.keySet());
		
		Collections.sort(l);
		
		Node r = null;
		for (Integer i : l) {
			r = insert(r, i);
		}
		return r;
	}

	public static Node insert(Node head, int data) {
		Node p = new Node(data);
		if (head == null)
			head = p;
		else if (head.next == null)
			head.next = p;
		else {
			Node start = head;
			while (start.next != null)
				start = start.next;
			start.next = p;

		}
		return head;
	}

	public static void display(Node head) {
		Node start = head;
		while (start != null) {
			System.out.print(start.data + " ");
			start = start.next;
		}
	}

	public static void main(String args[]) {
		Node head = null;
		head = insert(head, 3);
		head = insert(head, 9);
		head = insert(head, 9);
		head = insert(head, 11);
		head = insert(head, 11);
		head = insert(head, 11);
		head = insert(head, 11);
		head = insert(head, 89);
		head = insert(head, 89);
		head = insert(head, 100);
		head = insert(head, 100);
		head = insert(head, 101);
		head = insert(head, 102);
		head = insert(head, 103);
		head = insert(head, 108);
		head = insert(head, 200);
		head = insert(head, 250);
		head = insert(head, 250);
		head = insert(head, 250);
		head = insert(head, 250);
		head = removeDuplicates(head);
		display(head);
	}
}
