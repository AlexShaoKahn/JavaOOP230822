package com.gmail.kahn.shao.alex.homework.internetshop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

public class Products implements Iterable<Product> {
    private Map<Integer, Product> products;

    public Products() {
        products = new HashMap<>();
    }

    public int addProduct(Product product) {
        if (product.getAmount() < 0) throw new IllegalArgumentException("Amount can't be negative!");
        if (product.getPrice() < 0) throw new IllegalArgumentException("Price can't be negative!");
        if (contains(product.getName()))
            System.out.println("Product " + product.getName() + " already exists!");
        else products.put(product.getProductId(), product);
        return product.getProductId();
    }

    public void removeProduct(int id) {
        if (products.containsKey(id)) products.remove(id);
        else System.out.println("Product with ID " + id + " not found!");
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public Product getProduct(int id) throws CloneNotSupportedException {
        return (Product) products.get(id).clone();
    }

    public Product getRealProduct(int id) {
        return products.get(id);
    }

    public void setProductAmount(int id, int amount) {
        products.get(id).setAmount(amount);
    }

    public boolean contains(String name) {
        for (Product value : products.values()) {
            if (value.getName().equals(name)) return true;
        }
        return false;
    }

    public boolean contains(int id) {
        return products.containsKey(id);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        for (Product value : products.values()) {
            result.append(value.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }

    @Override
    public Iterator<Product> iterator() {
        return products.values().iterator();
    }

    @Override
    public void forEach(Consumer<? super Product> action) {
        Iterable.super.forEach(action);
    }
}
