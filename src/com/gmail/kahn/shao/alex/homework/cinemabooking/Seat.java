package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class Seat {
    private int number;
    private boolean isFree;

    public Seat(int seatNumber) {
        number = seatNumber;
        isFree = Boolean.TRUE;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    @Override
    public String toString() {
        return isFree ? String.format("%2d", number) : String.format("%2s", "X");
    }
}
