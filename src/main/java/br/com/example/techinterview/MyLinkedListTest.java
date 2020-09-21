package br.com.example.techinterview;

public class MyLinkedListTest {

	public static void main(String args[]) {
		Node nodeA = new Node(6);
		Node nodeB = new Node(3);
		Node nodeC = new Node(4);
		Node nodeD = new Node(2);
		Node nodeE = new Node(1);
		
		nodeA.next = nodeB;
		nodeB.next = nodeC;
		nodeC.next = nodeD;
		nodeD.next = nodeE;
		
		nodeE.prev = nodeD;
		nodeD.prev = nodeC;
		nodeC.prev = nodeB;
		nodeB.prev = nodeA;
		
		System.out.println(nodeA.data);
		System.out.println(nodeA.next.data);
	}
}

class Node {
	int data;
	Node next;
	Node prev; // doubly-linked-list - has reference to previous node also 

	Node(int data) {
		this.data = data;
	}
}