package br.com.example.structure.array.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.example.structure.array.MyArrayObject;

public class MyArrayObjectTest {

	MyArrayObject myArrayObject = new MyArrayObject(5);
	Contact c4 = new Contact("Contact 4", "4567-8901", "contact4@email.com");

	@Before
	public void before() {
		Contact c1 = new Contact("Contact 1", "1234-4567", "contact1@email.com");
		Contact c2 = new Contact("Contact 2", "2345-6789", "contact2@email.com");
		Contact c3 = new Contact("Contact 3", "3456-7890", "contact3@email.com");
		
		myArrayObject.add(c1);
		myArrayObject.add(c2);
		myArrayObject.add(c3);
		
		System.out.println("myArrayObject: " + myArrayObject.toString());
	}

	@Test
	public void test() {
		Assert.assertEquals(myArrayObject.indexOf(c4), -1);
		myArrayObject.add(c4);
		Assert.assertEquals(myArrayObject.indexOf(c4), 3);
	}

	@After
	public void after() {
		System.out.println("myArrayObject: " + myArrayObject.toString());
	}

}
