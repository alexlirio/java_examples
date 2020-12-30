package br.com.example;

import java.util.List;
import java.util.ArrayList;

public class CollectionsTest {
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		
		String c1 = new String();
		String c2 = new String();
		String c3 = new String();
		String c4 = new String();

		list1.add(c1);
		list1.add(c2);
		list1.add(c3);
		list1.add(c4);

		//repare que nesta lista tem os mesmos objetos 'c3' e 'c4' da list1
		list2.add(c3);
		list2.add(c4);
		
		System.out.println(list1.size());
		list1.removeAll(list2);
		System.out.println(list1.size());
	}

}
