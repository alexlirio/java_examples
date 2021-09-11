package br.com.example.designpattern.structural.bridge;

public class Triangle extends ShapeBridge {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Triangle drawn. " + color.fill();
    }
}
