package br.com.example.hackerrank.solution5;

import java.util.Scanner;

class Solution {

    public static Node insert(Node head,int data) {
        //Complete this method
    	if (head == null) {
			return new Node(data);
		}
    	
    	if (head.next != null) {
			head.next = insert(head.next, data);
			return head;
		}
    	
    	head.next = new Node(data);
    	return head;
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}