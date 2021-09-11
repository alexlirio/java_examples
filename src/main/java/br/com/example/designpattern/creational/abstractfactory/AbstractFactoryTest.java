package br.com.example.designpattern.creational.abstractfactory;

public interface AbstractFactoryTest<T> {

    public static void main(String[] args) {

        AnimalFactory animalFactory = new AnimalFactory();

        Animal dog = animalFactory.create("dog");
        System.out.println(dog.makeSound());
        
        Animal duck = animalFactory.create("duck");
        System.out.println(duck.makeSound());
    }
}