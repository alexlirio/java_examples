package br.com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Convert {

    public static void main(String[] args) {

        List<String> myList = new ArrayList<>();
        myList.add("monkey");
        myList.add("cat");
        myList.add("dog");
        myList.add("dog");
        
        System.out.println(myList.getClass().getSimpleName() + ": " + myList);
        
        // List to Set
        Set<String> mySet1 = new HashSet<String>(myList);
        System.out.println(mySet1.getClass().getSimpleName() + ": " + mySet1);

        // Set to List
        List<String> myList1 = new ArrayList<String>();
        myList1.addAll(mySet1);
        System.out.println(myList1.getClass().getSimpleName() + ": " + myList1);
    }
}
