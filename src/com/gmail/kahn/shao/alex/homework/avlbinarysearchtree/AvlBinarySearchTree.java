package com.gmail.kahn.shao.alex.homework.avlbinarysearchtree;

public class AvlBinarySearchTree<T extends Comparable<? super T>> implements BinarySearchTreeMethods<T> {
    private BranchDifference maxBranchDifference;
    private Node<T> root;
    private int size;

    public AvlBinarySearchTree(BranchDifference branchDifference) {
        maxBranchDifference = branchDifference;
    }

    private int getLevel(Node<T> node) {
        return node == null ? -1 : node.getLevel();
    }

    private void updateLevel(Node<T> node) {
        node.setLevel(1 + Math.max(getLevel(node.getLeft()), getLevel(node.getRight())));
    }

    private int checkImbalance(Node<T> node) {
        return getLevel(node.getRight()) - getLevel(node.getLeft());
    }

    public int getLongestBranch() {
        return root.getLevel() + 1;
    }

    private Node<T> balance(Node<T> node) {
        updateLevel(node);
        int imbalance = checkImbalance(node);
        if (imbalance > maxBranchDifference.getDifference()) {
            if (checkImbalance(node.getRight()) < 0) {
                node.setRight(turnRight(node.getRight()));
                return turnLeft(node);
            } else return turnLeft(node);
        }
        if (imbalance < -maxBranchDifference.getDifference()) {
            if (checkImbalance(node.getLeft()) > 0) {
                node.setLeft(turnLeft(node.getLeft()));
                return turnRight(node);
            } else return turnRight(node);
        }
        return node;
    }

    private Node<T> turnLeft(Node<T> node) {
        Node<T> right = node.getRight();
        Node<T> left = right.getLeft();
        right.setLeft(node);
        node.setRight(left);
        updateLevel(node);
        updateLevel(right);
        return right;
    }

    private Node<T> turnRight(Node<T> node) {
        Node<T> left = node.getLeft();
        Node<T> right = left.getRight();
        left.setRight(node);
        node.setLeft(right);
        updateLevel(node);
        updateLevel(left);
        return left;
    }

    @Override
    public boolean add(T data) {
        int oldSize = size;
        root = add(data, root);
        return oldSize < size ? true : false;
    }

    private Node<T> add(T data, Node<T> node) {
        if (node == null) {
            size++;
            return new Node<>(data);
        }
        int compared = node.compareTo(data);
        if (compared == 0) return node;
        if (compared > 0) node.setLeft(add(data, node.getLeft()));
        else if (compared < 0) node.setRight(add(data, node.getRight()));
        updateLevel(node);
        return balance(node);
    }

    private Node<T> find(T data, Node<T> node) {
        if (node == null || node.compareTo(data) == 0) return node;
        else if (node.compareTo(data) > 0) return find(data, node.getLeft());
        else return find(data, node.getRight());
    }

    private Node<T> lastLeft(Node<T> node) {
        if (node.getLeft() != null) return lastLeft(node.getLeft());
        else return node;
    }

    private Node<T> findMin(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.getLeft() == null) {
            return node;
        }
        return findMin(node.getLeft());
    }

    @Override
    public boolean remove(T data) {
        int oldSize = size;
        remove(data, root);
        return oldSize > size ? true : false;
    }

    private Node<T> remove(T data, Node<T> node) {
        if (node == null) return null;
        else if (node.compareTo(data) > 0) node.setLeft(remove(data, node.getLeft()));
        else if (node.compareTo(data) < 0) node.setRight(remove(data, node.getRight()));
        else {
            if (node.getRight() == null) node = node.getLeft();
            else if (node.getLeft() == null) node = node.getRight();
            else {
                Node<T> temp = lastLeft(node.getRight());
                node.setElement(temp.getElement());
                node.setRight(remove(node.getElement(), node.getRight()));
            }
        }
        if (node == null) {
            size--;
            return null;
        } else return balance(node);

    }

    @Override
    public boolean contains(T data) {
        return find(data, root) == null ? false : true;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public String toString() {
        var result = new StringBuilder("Tree: [");
        result.append(tree2string(root));
        result.delete(result.length() - 2, result.length());
        result.append("], size: ").append(size());
        return result.toString();
    }

    private String tree2string(Node<T> node) {
        var result = new StringBuilder();
        if (node != null) {
            result
                    .append(tree2string(node.getLeft()))
                    .append(node.getElement().toString())
                    .append(", ")
                    .append(tree2string(node.getRight()));
        }
        return result.toString();
    }
}
