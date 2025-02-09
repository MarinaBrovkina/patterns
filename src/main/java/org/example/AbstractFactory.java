package org.example;

public class AbstractFactory {
    public static void main(String[] args) {
        VehicleFactoryCreator factoryCreator = new VehicleFactoryCreator();
        Factories carsFactory = factoryCreator.createFactories("Cars");
        Factories bikeFactory = factoryCreator.createFactories("Motorbikes");

        Cars toyota = carsFactory.createCar("Toyota");
        Motorbikes harley = bikeFactory.createMotorbike("Harley");
        toyota.drive();
        harley.drive();
    }
}

interface Cars {
    void drive();
}

class Toyota implements Cars {
    @Override
    public void drive() {
        System.out.println("A trip to the mountains in a Land Rover");
    }
}

class BMW implements Cars {
    @Override
    public void drive() {
        System.out.println("City Tour in a Range Rover");
    }
}

class CarsFactory implements Factories {
    public Cars createCar(String typeOfCar) {
        return switch (typeOfCar) {
            case "BMW" -> new BMW();
            case "Toyota" -> new Toyota();
            default -> null;
        };
    }

    @Override
    public Motorbikes createMotorbike(String typeOfMotorbike) {
        return null;
    }
}

interface Motorbikes {
    void drive();
}

class Yamaha implements Motorbikes {
    @Override
    public void drive() {
        System.out.println("We participate in races on a Yamaha");
    }
}

class Harley implements Motorbikes {
    @Override
    public void drive() {
        System.out.println("We are going a long travel on a Harley");
    }
}

class MotorbikesFactory implements Factories {
    public Motorbikes createMotorbike(String typeOfMotorbike) {
        return switch (typeOfMotorbike) {
            case "Yamaha" -> new Yamaha();
            case "Harley" -> new Harley();
            default -> null;
        };
    }

    @Override
    public Cars createCar(String typeOfCar) {
        return null;
    }
}

interface Factories {
    Cars createCar(String typeOfCar);

    Motorbikes createMotorbike(String typeOfMotorbike);
}

class VehicleFactoryCreator {
    public Factories createFactories(String typeOfFactory) {
        return switch (typeOfFactory) {
            case "Cars" -> new CarsFactory();
            case "Motorbikes" -> new MotorbikesFactory();
            default -> null;
        };
    }
}



