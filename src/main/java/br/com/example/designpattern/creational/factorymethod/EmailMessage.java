package br.com.example.designpattern.creational.factorymethod;

public class EmailMessage implements Message {

	@Override
	public void send(String msg) {
		System.out.println("Email: " + msg);
	}

}
