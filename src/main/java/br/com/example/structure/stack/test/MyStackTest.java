package br.com.example.structure.stack.test;

import java.util.Stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.example.structure.stack.MyStack;

public class MyStackTest {

    MyStack<Integer> myStack = new MyStack<>();
    
    Stack<Integer> javaStack = new Stack<>();

    @Before
    public void before() {
    }

    @Test
    public void myStackTest() {
        Assert.assertTrue(myStack.isEmpty());
        System.out.println("myStack.isEmpty(): " + myStack);
        
        for (int i = 1; i <= 11; i++) {
            myStack.push(i);
        }
        Assert.assertEquals(myStack.size(), 11);
        System.out.println("myStack.size(): " + myStack);

        myStack.push(99);
        Assert.assertEquals(myStack.size(), 12);
        System.out.println("myStack.push(99): " + myStack);
        
        Assert.assertEquals(myStack.peek(), Integer.valueOf(99));
        System.out.println("myStack.peek(): " + myStack);
        
        Assert.assertEquals(myStack.pop(), Integer.valueOf(99));
        System.out.println("myStack.pop(): " + myStack);
    }
    
    @Test
    public void javaStackTest() {
        Assert.assertTrue(javaStack.isEmpty());
        System.out.println("javaStack.isEmpty(): " + javaStack);
        
        for (int i = 1; i <= 11; i++) {
            javaStack.push(i);
        }
        Assert.assertEquals(javaStack.size(), 11);
        System.out.println("javaStack.size(): " + javaStack);
        
        javaStack.push(99);
        Assert.assertEquals(javaStack.size(), 12);
        System.out.println("javaStack.push(99): " + javaStack);
        
        Assert.assertEquals(javaStack.peek(), Integer.valueOf(99));
        System.out.println("javaStack.peek(): " + javaStack);
        
        Assert.assertEquals(javaStack.pop(), Integer.valueOf(99));
        System.out.println("javaStack.pop(): " + javaStack);
    }

    @After
    public void after() {
    }

}
