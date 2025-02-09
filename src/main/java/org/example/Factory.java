package org.example;

public class Factory {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        Car lr = factory.create("LandRover");
        Car rr = factory.create("RangeRover");
        lr.drive();
        rr.drive();
    }
}

interface Car {
    void drive();
}

class LandRover implements Car {
    @Override
    public void drive() {
        System.out.println("A trip to the mountains in a Land Rover");
    }
}

class RangeRover implements Car {
    @Override
    public void drive() {
        System.out.println("City Tour in a Range Rover");
    }
}

class CarFactory {
    public Car create(String typeOfCare) {
        return switch (typeOfCare) {
            case "LandRover" -> new LandRover();
            case "RangeRover" -> new RangeRover();
            default -> null;
        };
    }
}
