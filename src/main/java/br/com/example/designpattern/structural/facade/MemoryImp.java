package br.com.example.designpattern.structural.facade;

public class MemoryImp implements Memory {

    public void load() {
        System.out.println("load memory");
    }

    public void free() {
        System.out.println("free memory");
    }
}
