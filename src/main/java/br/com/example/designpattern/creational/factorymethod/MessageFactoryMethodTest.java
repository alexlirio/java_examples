package br.com.example.designpattern.creational.factorymethod;

public class MessageFactoryMethodTest {
	
    public static void main(String[] args) {

        MessageFactoryMethod messageFactoryMethod = new MessageFactoryMethod();

        Message email = messageFactoryMethod.create("email");
        email.send("mensagem 1");
        
        Message sms = messageFactoryMethod.create("sms");
        sms.send("mensagem 2");
    }

}
