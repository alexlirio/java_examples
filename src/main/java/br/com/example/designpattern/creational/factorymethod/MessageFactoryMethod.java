package br.com.example.designpattern.creational.factorymethod;

/**
 * Factory Method:
 * Recognizable by creational methods returning an implementation of an abstract/interface type.
 */
public class MessageFactoryMethod {
	
	public Message create(String type) {
        if ("email".equalsIgnoreCase(type)) {
            return new EmailMessage();
        } else if ("sms".equalsIgnoreCase(type)) {
            return new SmsMenssage();
        }
        return null;
	}

}
