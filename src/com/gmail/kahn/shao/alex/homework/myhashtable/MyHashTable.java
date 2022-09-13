package com.gmail.kahn.shao.alex.homework.myhashtable;

import java.util.LinkedList;
import java.util.List;

public class MyHashTable<T> implements MyHashTableMethods<T> {
    private static final int HASH_TABLE_SIZE = 100;
    private final List<T>[] hashArray;

    public MyHashTable() {
        hashArray = new List[HASH_TABLE_SIZE];
    }

    @Override
    public boolean add(T data) {
        if (data == null) throw new NullPointerException("Element can't be NULL");
        int index = Math.abs(data.hashCode()) % HASH_TABLE_SIZE;
        if (hashArray[index] == null) hashArray[index] = new LinkedList<>();
        if (hashArray[index].contains(data)) return false;
        hashArray[index].add(data);
        return true;
    }

    public boolean addAll(T[] data) {
        for (T e : data) {
            add(e);
        }
        return true;
    }

    @Override
    public boolean remove(T data) {
        if (data == null) throw new NullPointerException("Element can't be NULL");
        int index = Math.abs(data.hashCode()) % HASH_TABLE_SIZE;
        if (hashArray[index] == null) return false;
        if (!hashArray[index].contains(data)) return false;
        hashArray[index].remove(data);
        if (hashArray[index].size() == 0) hashArray[index] = null;
        return true;
    }

    @Override
    public boolean contains(T data) {
        if (data == null) throw new NullPointerException("Element can't be NULL");
        int index = Math.abs(data.hashCode()) % HASH_TABLE_SIZE;
        if (hashArray[index] == null) return false;
        if (hashArray[index].contains(data)) return true;
        return false;
    }

    @Override
    public int size() {
        int size = 0;
        for (List<T> e : hashArray) {
            if (!(e == null) && e.size() > 0)
                size += e.size();
        }
        return size;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("[");
        for (List<T> h : hashArray) {
            if (!(h == null))
                for (T e : h) {
                    if (!(e == null)) result.append(e).append(", ");
                }
        }
        if (result.length() > 1) result.setLength(result.length() - 2);
        result.append("]");
        return result.toString();
    }
}
