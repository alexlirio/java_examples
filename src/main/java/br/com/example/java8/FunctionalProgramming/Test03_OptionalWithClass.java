package br.com.example.java8.FunctionalProgramming;

import java.util.Optional;

public class Test03_OptionalWithClass {

	public static void main(String[] args) {
		
		// Optional with classes
		
		Insurance insurance = new Insurance();
		insurance.setType("National");
		
		Car car = new Car();
		car.setModel("Conversive");
		car.setInsurance(insurance);
//		car.setInsurance(null); //Test to return 'orElse' value. 
		
		Client client = new Client();
		client.setName("John");
		client.setCar(car);
//		client.setCar(null); //Test to return 'orElse' value.
		
		//Example to avoid NullPointException
		String result = Optional.ofNullable(client)
				.flatMap(Client::getOptionalCar) //Use 'flatMap' if the method('getOptionalCar') return a 'Optional'
				.map(Car::getInsurance) //Use 'map' if the method('getInsurance') don't return a 'Optional'
				.map(Insurance::getType)
				.orElse("No insurance name");
		System.out.println(result);
		
		//Example to filter
		Optional<Insurance> insuranceOptional = Optional.ofNullable(insurance);
		insuranceOptional.filter(i -> i.getType().equalsIgnoreCase("National")).ifPresent(x -> System.out.println("Is National"));
	}
}

class Client {
	
	public String name;
	public Car car;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	/**
	 * Created to test the 'flaMap' method. 
	 * @return a Optional<Car>
	 */
    public Optional<Car> getOptionalCar() {
        return Optional.ofNullable(car);
    }
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", car=" + car + "]";
	}
}

class Car {
	
	public String model;
	public Insurance insurance;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
    
	@Override
	public String toString() {
		return "Car [model=" + model + ", insurance=" + insurance + "]";
	}
}

class Insurance {
	
	public String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Insurance [type=" + type + "]";
	}
}
