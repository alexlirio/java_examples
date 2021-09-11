package br.com.example.designpattern.creational.abstractfactory;

/**
 * Abstract factory:
 * Recognizable by creational methods returning the factory itself which in turn can be used to create another abstract/interface type.
 */
public interface AbstractFactory<T> {
    T create(String type) ;
}