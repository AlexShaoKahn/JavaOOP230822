package com.gmail.kahn.shao.alex.homework.myhashtable;

import java.util.Arrays;

public class MyAutoSizableArray<T> {
    private final static int DEFAULT_ARRAY_SIZE = 10;
    private T[] array;
    private int size;

    public MyAutoSizableArray() {
        array = (T[]) new Object[DEFAULT_ARRAY_SIZE];
        size = 0;
    }

    public MyAutoSizableArray<T> add(T element) {
        if (element == null) throw new NullPointerException("Element can't be NULL");
        expand();
        array[size++] = element;
        return this;
    }

    public void addAll(T[] array) {
        for (T e : array) {
            add(e);
        }
    }

    public void remove(int index) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index + " is wrong index. Array size is " + size);
        T[] newArray = (T[]) new Object[size - 1];
        for (int i = 0, j = 0; i < size; i++) {
            if (!(i == index)) {
                newArray[j++] = array[i];
            }
        }
        array = newArray;
        size--;
        trim();
    }

    public void remove2(int index) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index + " is wrong index. Array size is " + size);
        for (int i = index; i < size-1; i++) {
            array[i]=array[i+1];
        }
        size--;
        trim();
    }

    private void expand() {
        if (size == array.length) array = Arrays.copyOf(array, array.length + array.length / 4);
    }

    private void trim() {
        if (size + size / 4 < array.length) array = Arrays.copyOf(array, size + size / 4);
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element.hashCode() == array[i].hashCode() || element.equals(array[i])) return true;
        }

        return false;
    }

    public T get(int index) {
        if (index > size || index < 0)
            throw new ArrayIndexOutOfBoundsException(index + " is wrong index. Array size is " + size);
        return array[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) return i;
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        for (int i = size - 1; i <= 0; i--) {
            if (array[i].equals(element)) return i;
        }
        return -1;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(array[i].toString());
            if (i < size - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}
