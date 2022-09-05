package com.gmail.kahn.shao.alex.homework.internetshop;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int seed = 71;
        int result = seed;
        result = seed * (result + name.hashCode());
        return result;
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
}
