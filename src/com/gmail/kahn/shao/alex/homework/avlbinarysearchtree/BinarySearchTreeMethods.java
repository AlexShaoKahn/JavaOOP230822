package com.gmail.kahn.shao.alex.homework.avlbinarysearchtree;

public interface BinarySearchTreeMethods<T> {
    boolean add(T data);

    boolean remove(T data);

    boolean contains(T data);

    int size();
}
