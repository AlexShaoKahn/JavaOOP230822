package com.gmail.kahn.shao.alex.homework.avlbinarysearchtree;

import java.util.*;
import java.util.function.Consumer;

public class Nodes<T extends Comparable<? super T>> implements Iterable<Node<T>> {
    private Set<Node<T>> nodes;

    public Nodes() {
        nodes = new HashSet<>();
    }

    public boolean add(T data) {
        return nodes.add(new Node<>(data));
    }

    public boolean remove(T data) {
        return nodes.remove(data);
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return (Iterator<Node<T>>) nodes.iterator();
    }

    @Override
    public void forEach(Consumer<? super Node<T>> action) {
        Iterable.super.forEach(action);
    }
}
