package br.com.example.designpattern.creational.builder;

public class CustomerBuilderTest {

    public static void main(String[] args) {
        Customer customer = new CustomerBuilder()
                .id(1)
                .name("Alex Lirio")
                .build();
        System.out.println(customer.getName());
    }
}
