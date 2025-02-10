package org.example;

public class Decorator {
    public static void main(String[] args) {
        Figure square = new Square();
        Figure redSquare = new RedFigureDecorator(new Square());
        Figure redRhombus = new RedFigureDecorator(new Rhombus());
        System.out.println("Regular square: ");
        square.draw();
        System.out.println("Colored square: ");
        redSquare.draw();
        System.out.println("Colored rhombus: ");
        redRhombus.draw();
    }
}

interface Figure {
    void draw();
}

class Square implements Figure {
    @Override
    public void draw() {
        System.out.println("Я квадрат ^_^");
    }
}

class Rhombus implements Figure {
    @Override
    public void draw() {
        System.out.println("Я ромб ^o^");
    }
}

abstract class FigureDecorator implements Figure {
    Figure decoratorFigure;

    public FigureDecorator(Figure decoratorFigure) {
        this.decoratorFigure = decoratorFigure;
    }

    @Override
    public void draw() {
        decoratorFigure.draw();
    }
}

class RedFigureDecorator extends FigureDecorator {

    public RedFigureDecorator(Figure decoratorFigure) {
        super(decoratorFigure);
    }

    @Override
    public void draw() {
        decoratorFigure.draw();
        setRedFill(decoratorFigure);
    }

    private void setRedFill(Figure decoratorFigure) {
        System.out.println("Цвет красный");
    }
}