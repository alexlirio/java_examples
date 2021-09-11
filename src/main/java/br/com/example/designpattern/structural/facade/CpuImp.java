package br.com.example.designpattern.structural.facade;

public class CpuImp implements Cpu {

    public void start() {
        System.out.println("start cpu");
    }

    public void shutdown() {
        System.out.println("shutdown cpu");
    }
}
