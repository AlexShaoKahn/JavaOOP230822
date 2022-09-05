package com.gmail.kahn.shao.alex.homework.zoo;

public class Client {
    private String name;
    private double cash;
    private boolean haveTicket;

    public Client(String name, double cash) {
        this(name, cash, Boolean.FALSE);
    }

    private Client(String name, double cash, boolean haveTicket) {
        this.name = name;
        this.cash = cash;
        this.haveTicket = haveTicket;
    }

    public void feedAnimal(Animal animal) {
        if (haveTicket) {
            System.out.print(animal.getClass().getSimpleName() + " says: ");
            animal.voice();
        } else System.out.println("You don't have a ticket!");
    }

    public double getCash() {
        return cash;
    }

    public boolean isHaveTicket() {
        return haveTicket;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public void setHaveTicket(boolean haveTicket) {
        this.haveTicket = haveTicket;
    }

    @Override
    public String toString() {
        return "Client " + name + ", money: " + String.format("%.2f", cash);
    }
}
