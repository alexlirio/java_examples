package br.com.example.designpattern.creational.factorymethod;

public class SmsMenssage implements Message {

	@Override
	public void send(String msg) {
		System.out.println("SMS: " + msg);
	}

}
