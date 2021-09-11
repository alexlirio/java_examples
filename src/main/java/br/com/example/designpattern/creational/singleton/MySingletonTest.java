package br.com.example.designpattern.creational.singleton;

public class MySingletonTest {

    public static void main(String[] args) {

        MySingleton mySingleton1 = MySingleton.getInstance();
        MySingleton mySingleton2 = MySingleton.getInstance();

        System.out.println("mySingleton1: " + mySingleton1);
        System.out.println("mySingleton1: " + mySingleton1.getMsg());
        System.out.println("mySingleton2: " + mySingleton2);
        System.out.println("mySingleton2: " + mySingleton2.getMsg());
    }
}
