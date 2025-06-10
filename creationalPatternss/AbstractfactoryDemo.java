package creationalPatternss;

// Product interface
interface Vehicle {
    String getType();
}

// Concrete Products
class Car implements Vehicle {
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    public String getType() {
        return "Bike";
    }
}

// Abstract Factory
interface VehicleFactory {
    Vehicle createVehicle();
}

// Concrete Factories
class CarFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BikeFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }
}

// Main Class
public class AbstractFactoryVehicleDemo {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();
        System.out.println("Created: " + car.getType());

        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle bike = bikeFactory.createVehicle();
        System.out.println("Created: " + bike.getType());
    }
}
