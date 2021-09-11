package br.com.example.designpattern.structural.adapter;

/**
 * Adapter:
 * Recognizable by creational methods taking an instance of different abstract/interface type and returning an
 * implementation of own/another abstract/interface type which decorates/overrides the given instance.
 */
public class CarAdapter implements CarKmh {

    private CarMph carMph;

    public CarAdapter(CarMph carMph) {
        super();
        this.carMph = carMph;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(carMph.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}
