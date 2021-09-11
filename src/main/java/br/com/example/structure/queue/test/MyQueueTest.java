package br.com.example.structure.queue.test;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.example.structure.queue.MyQueue;

public class MyQueueTest {

	MyQueue<Integer> myQueue = new MyQueue<>();
	
	Queue<Integer> javaQueue = new LinkedList<>();
	
	@Before
	public void before() {
	}

	@Test
	public void myQueueTest() {
		
		System.out.println("myQueue: " + myQueue);
		
		Assert.assertTrue(myQueue.isEmpty());
		System.out.println("myQueue.isEmpty(): " + myQueue.isEmpty());
		
		Assert.assertEquals(myQueue.size(), 0);
		System.out.println("myQueue.size(): " + myQueue.size());
		
		for (int i = 1; i <= 3; i++) {
			myQueue.enqueue(i); // add
		}
		
		System.out.println("myQueue: " + myQueue);
		
		Assert.assertTrue(!myQueue.isEmpty());
		System.out.println("myQueue.isEmpty(): " + myQueue.isEmpty());
		
		Assert.assertEquals(myQueue.size(), 3);
		System.out.println("myQueue.size(): " + myQueue.size());
		
		Assert.assertEquals(myQueue.peek(), Integer.valueOf(1));
		System.out.println("myQueue.peek(): " + myQueue.peek());
		
		System.out.println("myQueue: " + myQueue);
		
		Integer val = myQueue.dequeue(); // remove
		Assert.assertEquals(val, Integer.valueOf(1));
		System.out.println("myQueue.dequeue(): " + val);
		
		System.out.println("myQueue: " + myQueue);
	}
	
	@Test
	public void javaQueueTest() {
		System.out.println("javaQueue: " + javaQueue);
		
		Assert.assertTrue(javaQueue.isEmpty());
		System.out.println("javaQueue.isEmpty(): " + javaQueue.isEmpty());
		
		Assert.assertEquals(javaQueue.size(), 0);
		System.out.println("javaQueue.size(): " + javaQueue.size());
		
		for (int i = 1; i <= 3; i++) {
			javaQueue.add(i); // enqueue
		}
		
		System.out.println("javaQueue: " + javaQueue);
		
		Assert.assertTrue(!javaQueue.isEmpty());
		System.out.println("javaQueue.isEmpty(): " + javaQueue.isEmpty());
		
		Assert.assertEquals(javaQueue.size(), 3);
		System.out.println("javaQueue.size(): " + javaQueue.size());
		
		Assert.assertEquals(javaQueue.peek(), Integer.valueOf(1));
		System.out.println("javaQueue.peek(): " + javaQueue.peek());
		
		System.out.println("javaQueue: " + javaQueue);
		
		Integer val = javaQueue.remove(); // denqueue
		Assert.assertEquals(val, Integer.valueOf(1));
		System.out.println("javaQueue.remove(): " + val);
		
		System.out.println("javaQueue: " + javaQueue);
	}

	@After
	public void after() {
	}

}
