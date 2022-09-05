package com.gmail.kahn.shao.alex.homework.internetshop;

public class Clothing extends Product implements Cloneable {
    public Clothing(String name, int amount, double price) {
        super(name, amount, price);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Clothing(getName(), getAmount(), getPrice());
    }

}
