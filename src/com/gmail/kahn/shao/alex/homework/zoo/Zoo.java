package com.gmail.kahn.shao.alex.homework.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;
    private Client client;
    private double entryCost;

    public Zoo(double entryCost) {
        this.entryCost = entryCost;
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void createClient(String name, double cash) {
        client = new Client(name, cash);
    }

    private void buyTicket(Client client, double cost) {
        if (client.getCash() < cost) System.out.println("Not enough money!");
        else {
            client.setCash(client.getCash() - cost);
            client.setHaveTicket(Boolean.TRUE);
            System.out.println("Ticket cost: " + String.format("%.2f", cost));
        }
    }

    public void buyTicket(Client client) {
        buyTicket(client, entryCost);
    }

    public void goOnTour(Client client) {
        buyTicket(client, entryCost * animals.size() * 2 / 3);
        animals.forEach(a -> client.feedAnimal(a));
    }

    public Client getClient() {
        return client;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
