package com.gmail.kahn.shao.alex.homework.avlbinarysearchtree;

public enum BranchDifference {
    ONE(1),
    TWO(2);

    private final int difference;

    BranchDifference(int difference) {
        this.difference = difference;
    }

    public int getDifference() {
        return difference;
    }
}
