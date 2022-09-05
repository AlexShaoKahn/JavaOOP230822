package com.gmail.kahn.shao.alex.homework.internetshop;

import java.util.Scanner;

public class Client {
    private String name;
    private double cash;
    private Products ownedProducts;
    private Products shoppingBucket;

    public Client(String name, double cash) {
        this.name = name;
        this.cash = cash;
        ownedProducts = new Products();
        shoppingBucket = new Products();
    }

    public void addProduct(Products products, int id, int amount) throws CloneNotSupportedException {
        if (!products.contains(id)) System.out.println("Product with ID " + id + " not found!");
        else if (amount > products.getProduct(id).getAmount())
            System.out.println("Not enough product amount at the store!");
        else {
            products.setProductAmount(id, products.getProduct(id).getAmount() - amount);
            int newId = shoppingBucket.addProduct(products.getProduct(id));
            shoppingBucket.getRealProduct(newId).setAmount(amount);
        }
    }

    public void buyBucket() {
        double bucketPrice = 0;
        for (Product product : shoppingBucket) {
            bucketPrice += product.getPrice() * product.getAmount();
        }
        var scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Bucket price is: " + String.format("%.2f", bucketPrice));
            System.out.print("Do you want to pay?[y/n]: ");
            answer = scanner.next();
        } while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n"));
        if (answer.toLowerCase().equals("y"))
            if (cash < bucketPrice) System.out.println("Not enough money!");
            else {
                cash -= bucketPrice;
                for (Product product : shoppingBucket) {
                    ownedProducts.addProduct(product);
                }
                shoppingBucket = new Products();
            }
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("Client: ").append(name).append(", cash: ").append(String.format("%.2f", cash)).append(System.lineSeparator());
        if (!shoppingBucket.isEmpty()) result
                .append("Shopping bucket:").append(System.lineSeparator())
                .append(shoppingBucket.toString()).append(System.lineSeparator());
        if (!ownedProducts.isEmpty()) result
                .append("Owned products:").append(System.lineSeparator())
                .append(ownedProducts.toString());
        return result.toString();
    }
}
