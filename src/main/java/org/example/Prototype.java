package org.example;

public class Prototype {
    public static void main(String[] args) {
        Sheep bs = new BlackSheep("Sky");
        Sheep ws = new WhiteSheep("Dolly");
        Sheep cloneBS = bs.clone();
        Sheep cloneWS = ws.clone();
        cloneBS.setName("Night");
        cloneWS.setName("Moon");
        System.out.println("Black sheep: " + cloneBS.getName());
        System.out.println("White sheep: " + cloneWS.getName());
    }
}

interface Sheep {
    Sheep clone();

    String getName();

    void setName(String name);
}

class BlackSheep implements Sheep {
    String name;

    BlackSheep(String name) {
        this.name = name;
    }

    public Sheep clone() {
        return new BlackSheep(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class WhiteSheep implements Sheep {
    String name;

    WhiteSheep(String name) {
        this.name = name;
    }

    public Sheep clone() {
        return new WhiteSheep(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}