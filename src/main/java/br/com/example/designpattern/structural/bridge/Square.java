package br.com.example.designpattern.structural.bridge;

public class Square extends ShapeBridge {

    public Square(Color color) {
        super(color);
    }

    @Override
    public String draw() {
        return "Square drawn. " + color.fill();
    }
}
