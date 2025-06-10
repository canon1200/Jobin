package creationalPatternss;

// Prototype interface
interface VehiclePrototype extends Cloneable {
    VehiclePrototype clone();
}

// Concrete Prototype
class Vehicle implements VehiclePrototype {
    private String model;

    public Vehicle(String model) {
        this.model = model;
    }

    public VehiclePrototype clone() {
        return new Vehicle(model);
    }

    public String toString() {
        return "Vehicle Model: " + model;
    }
}

// Demo
public class VehiclePrototypeDemo {
    public static void main(String[] args) {
        Vehicle originalVehicle = new Vehicle("Tesla Model S");
        Vehicle clonedVehicle = (Vehicle) originalVehicle.clone();

        System.out.println(originalVehicle);
        System.out.println(clonedVehicle);
    }
}
