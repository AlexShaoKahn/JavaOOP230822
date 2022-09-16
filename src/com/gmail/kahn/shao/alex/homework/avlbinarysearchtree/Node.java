package com.gmail.kahn.shao.alex.homework.avlbinarysearchtree;

public class Node<T extends Comparable<? super T>> implements Comparable<T> {
    private int level;
    private Node<T> left;
    private Node<T> right;
    private T element;

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(T o) {
        return element.compareTo(o);
    }

    @Override
    public String toString() {
        return String.valueOf(element);
    }
}
