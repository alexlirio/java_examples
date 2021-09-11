package br.com.example.structure.array.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {

	ArrayList<String> arrayList = new ArrayList<String>();

	@Before
	public void before() {
		arrayList.add("A");
		arrayList.add("C");
		System.out.println("arrayList: " + arrayList.toString());
	}

	@Test
	public void test() {
		Assert.assertTrue(arrayList.contains("A"));
		
		arrayList.add(1, "B");
		Assert.assertEquals(arrayList.indexOf("B"), 1);
		
		arrayList.remove(0);
		
		arrayList.remove("B");
	}

	@After
	public void after() {
		System.out.println("arrayList: " + arrayList.toString());
	}

}
