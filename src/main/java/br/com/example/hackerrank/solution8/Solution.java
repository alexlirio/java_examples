package br.com.example.hackerrank.solution8;

/**
 * Binary Tree example.
 * Day 22: Binary Search Trees
 * @author alirio
 *
 */
public class Solution {

	public static int getHeight(Node root) {
		// Write your code here
//		System.out.println(root == null ? "null" : root.data);
		if (root == null) {
			return 0;
		}
		
		// If need to return the total "nodes", stop and return here.
//		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		int r = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		
		// If you need to return the total "edges" and not the total "nodes" is required to remove 1. 
		if (root.left == null && root.right == null) {
			r -= 1;
		}
		return r;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String args[]) {
		Node root = null;
		
		root = insert(root, 3);
		root = insert(root, 5);
		root = insert(root, 2);
		root = insert(root, 1);
		root = insert(root, 4);
		root = insert(root, 6);
		root = insert(root, 7);
		
		int height = getHeight(root);
		System.out.println(height);
	}
}