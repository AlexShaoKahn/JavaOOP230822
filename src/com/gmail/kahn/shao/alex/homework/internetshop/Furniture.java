package com.gmail.kahn.shao.alex.homework.internetshop;

public class Furniture extends Product implements Cloneable {
    public Furniture(String name, int amount, double price) {
        super(name, amount, price);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Furniture(getName(), getAmount(), getPrice());
    }
}
