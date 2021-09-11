package br.com.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
	
	String text;
	
	@Before
	public void initialize() {
		text = "Isto é um teste";
	}
	
	@Test
	public void something() {
		System.out.println("begin");
		Assert.assertEquals(Strings.Normalizar(text), "Isto e um teste");
		System.out.println("end"); //this line only run if the test line before run with success
	}
	
	@After
	public void deleteContent() {
		text = null;
	}

}
