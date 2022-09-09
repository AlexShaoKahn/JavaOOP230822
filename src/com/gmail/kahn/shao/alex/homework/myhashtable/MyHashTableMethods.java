package com.gmail.kahn.shao.alex.homework.myhashtable;

public interface MyHashTableMethods<T> {
    boolean add(T data);

    boolean remove(T data);

    boolean contains(T data);

    int size();
}
