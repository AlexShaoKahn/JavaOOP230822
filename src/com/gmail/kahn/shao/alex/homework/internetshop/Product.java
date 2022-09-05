package com.gmail.kahn.shao.alex.homework.internetshop;


import java.util.Objects;

abstract class Product implements Cloneable {
    private static int productIdCounter;
    private int productId = productIdCounter++;
    private String name;
    private int amount;
    private double price;

    public Product(String name, int amount, double price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result
                .append("Product ID: ").append(productId).append(", ")
                .append("name: ").append(name).append(", ")
                .append("amount: ").append(amount).append(", ")
                .append("price: ").append(String.format("%.2f", price));

        return result.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return product.name.equals(name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
