package com.gmail.kahn.shao.alex.homework.internetshop;

public class Runner {
    public static void main(String[] args) throws CloneNotSupportedException {
        var shop = new Shop();
        shop.addProduct(new Food("Apple", 50, 10));
        shop.addProduct(new Clothing("Shirt", 70, 20));
        shop.addProduct(new Furniture("Table", 30, 25));
        shop.addProduct(new Souvenirs("Flag", 60, 15));
        System.out.println(shop);

        shop.addClient("John", 1000);
        shop.getClient().addProduct(shop.getProducts(), 2, 10);
        shop.getClient().addProduct(shop.getProducts(), 0, 30);
        System.out.println(shop.getProducts());
        System.out.println(shop.getClient());

        shop.getClient().buyBucket();
        System.out.println(shop.getProducts());
        System.out.println(shop.getClient());
    }
}
