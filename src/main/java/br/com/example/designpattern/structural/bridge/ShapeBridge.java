package br.com.example.designpattern.structural.bridge;

/**
 * Bridge:
 * Recognizable by creational methods taking an instance of different abstract/interface type and returning an
 * implementation of own abstract/interface type which delegates/uses the given instance.
 */
public abstract class ShapeBridge {

    protected Color color;

    public ShapeBridge(Color color) {
        super();
        this.color = color;
    }

    abstract public String draw();
}
