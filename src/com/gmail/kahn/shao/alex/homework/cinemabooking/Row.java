package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class Row {
    private int number;
    private Seat seats[];

    public Row(int rowNumber, int seatsNumber) {
        number = rowNumber;
        seats = new Seat[seatsNumber];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat(i + 1);
        }
    }

    public int getNumber() {
        return number;
    }

    public Seat[] getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < seats.length; i++) {
            result.append(seats[i].toString());
            if (i < seats.length - 1) result.append(", ");
        }
        result.append("]");
        return result.toString();
    }
}
