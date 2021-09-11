package br.com.example.structure.array.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.example.structure.array.MyArray;

public class MyArrayTest {

	MyArray myArray1 = new MyArray(5);
	MyArray myArray2 = new MyArray(10);

	@Before
	public void before() {
		myArray1.add("element 0");
		myArray1.add("element 1");
		myArray1.add("element 2");
		System.out.println("myArray1: " + myArray1.toString());
		
		myArray2.add("B");
		myArray2.add("C");
		myArray2.add("E");
		System.out.println("myArray2: " + myArray2.toString());
	}

	@Test
	public void test() {
		Assert.assertEquals(myArray1.size(), 3);
		Assert.assertEquals(myArray1.get(2), "element 2");
		
		myArray2.add(0, "A");
		myArray2.add(3, "D");
		Assert.assertEquals(myArray2.get(1), "B");
		Assert.assertEquals(4, myArray2.indexOf("E"));
		myArray2.remove(2);
	}

	@After
	public void after() {
		System.out.println("myArray1: " + myArray1.toString());
		System.out.println("myArray2: " + myArray2.toString());
	}

}
