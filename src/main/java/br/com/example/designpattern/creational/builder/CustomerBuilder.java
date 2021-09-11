package br.com.example.designpattern.creational.builder;

/**
 * Builder:
 * Recognizable by creational methods returning the instance itself.
 */
public class CustomerBuilder {

	private Customer instance;

	public CustomerBuilder() {
		this.instance = new Customer();
	}

	public CustomerBuilder id(int id) {
		instance.setId(id);
		return this;
	}

	public CustomerBuilder name(String name) {
	    instance.setName(name);
	    return this;
	}

	public Customer build() {
		return instance;
	}
}
