package br.com.example.designpattern.structural.adapter;

public class CarAdapterTest {

    public static void main(String[] args) {
        CarMph carMph = new ChevroletCamaro();
        CarKmh carKmh = new CarAdapter(carMph);

        System.out.println(carMph.getSpeed() + " MPH"); // 100 MPH
        System.out.println(carKmh.getSpeed() + " Km/h"); // 160.934 Km/h
    }
}
