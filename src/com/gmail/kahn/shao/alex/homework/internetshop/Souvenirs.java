package com.gmail.kahn.shao.alex.homework.internetshop;

public class Souvenirs extends Product implements Cloneable {
    public Souvenirs(String name, int amount, double price) {
        super(name, amount, price);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Souvenirs(getName(), getAmount(), getPrice());
    }
}
