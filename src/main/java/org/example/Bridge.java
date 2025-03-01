package org.example;


public class Bridge {
    public static void main(String[] args) {
        BlueColor blueColor = new BlueColor();
        Triangle triangle = new Triangle(blueColor);
        triangle.draw();
        Circle circle = new Circle(new RedColor());
        circle.draw();
    }
}

interface Color {
    void fillColor();

}

class RedColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Red color");
    }

}

class BlueColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Blue color");
    }
}

abstract class Shape {
    Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Triangle");
        color.fillColor();
    }
}

class Circle extends Shape {

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("Circle");
        color.fillColor();
    }
}
