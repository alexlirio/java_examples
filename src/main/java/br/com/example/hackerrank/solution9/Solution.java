package br.com.example.hackerrank.solution9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Day 23: BST Level-Order Traversal
 */
class Solution {
	
	static List<Node> l = new LinkedList<Node>();

	static void levelOrder(Node root) {
		// Write your code here
        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                System.out.print(currentNode.data + " ");
            }
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();
        }
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
		
		//   3
		//   /\
		//   2  5
		//  /\   \
		// 1  4   7
		
		//3 2 5 1 4 7 
		
		Node root = null;
		
		root = insert(root, 3);
		root = insert(root, 5);
		root = insert(root, 4);
		root = insert(root, 7);
		root = insert(root, 2);
		root = insert(root, 1);

		levelOrder(root);
	}
}
