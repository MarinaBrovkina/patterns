package org.example;

public class Singleton {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();

    }

    private static final Singleton SINGLETON = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return SINGLETON;
    }
}
