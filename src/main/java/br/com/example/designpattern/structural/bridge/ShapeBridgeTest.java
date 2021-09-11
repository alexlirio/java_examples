package br.com.example.designpattern.structural.bridge;

public class ShapeBridgeTest {

    public static void main(String[] args) {

        //a square with red color
        ShapeBridge square = new Square(new Red());
        System.out.println(square.draw()); // "Square drawn. Color is Red"

        //a square with red color
        ShapeBridge triangle = new Triangle(new Blue());
        System.out.println(triangle.draw()); // "Triangle drawn. Color is Blue"
    }
 
}
