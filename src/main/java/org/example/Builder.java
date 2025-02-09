package org.example;

public class Builder {
    public static void main(String[] args) {
        Animal animal = new Animal.Build("Lili", 20).setBreed("Corgi").build();
        System.out.println(animal.getName() + " " + animal.getBreed());
    }
}

class Animal {
    String name;
    String owner;
    String species;
    String breed;
    int age;
    int weight;

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getSpecies() {
        return species;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public Animal(Build build) {
        this.name = build.name;
        this.owner = build.owner;
        this.species = build.species;
        this.breed = build.breed;
        this.age = build.age;
        this.weight = build.weight;
    }


    static class Build {
        String name;
        String owner;
        String species;
        String breed;
        int age;
        int weight;

        public Build(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Build setOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Build setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Build setSpecies(String species) {
            this.species = species;
            return this;
        }

        public Build setBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }
}

