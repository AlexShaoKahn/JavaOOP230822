package com.gmail.kahn.shao.alex.homework.internetshop;

public class Shop {
    private final String NAME = "Internet Shop";
    private Products products;
    private Client client;

    public Shop() {
        products = new Products();
    }

    public void addClient(String name, double cash) {
        client = new Client(name, cash);
    }

    public Client getClient() {
        return client;
    }

    public Products getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.addProduct(product);
    }

    public void removeProduct(int id) throws Throwable {
        products.removeProduct(id);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append(NAME).append(System.lineSeparator());
        result.append(products.toString()).append(System.lineSeparator());
        return result.toString();
    }
}
