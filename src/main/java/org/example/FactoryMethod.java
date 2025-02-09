package org.example;

public class FactoryMethod {
    public static void main(String[] args) {
        Toy toy = Toy.create();
    }
}

class Toy {
    private Toy() {
    }

    public static Toy create() {
        return new Toy();
    }
}

