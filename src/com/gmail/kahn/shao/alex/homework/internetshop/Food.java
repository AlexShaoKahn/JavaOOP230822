package com.gmail.kahn.shao.alex.homework.internetshop;

public class Food extends Product implements Cloneable {
    public Food(String name, int amount, double price) {
        super(name, amount, price);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Food(getName(), getAmount(), getPrice());
    }
}
