package com.gmail.kahn.shao.alex.homework.zoo;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        var zoo = new Zoo(50);
        zoo.addAnimal(new Horse());
        zoo.addAnimal(new Chimpanzee());
        zoo.addAnimal(new Kangaroo());

        int animalId = new Random().nextInt(zoo.getAnimals().size());
        System.out.println("--Feeding " + zoo.getAnimals().get(animalId).getClass().getSimpleName() + "--");
        zoo.createClient("John", 100);
        System.out.println(zoo.getClient());
        zoo.buyTicket(zoo.getClient());
        zoo.getClient().feedAnimal(zoo.getAnimals().get(animalId));

        System.out.println();
        System.out.println("--Feeding all animals--");
        zoo.createClient("Mary", 100);
        System.out.println(zoo.getClient());
        zoo.goOnTour(zoo.getClient());
    }
}
