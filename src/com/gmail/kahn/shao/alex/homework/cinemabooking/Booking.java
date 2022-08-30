package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class Booking {
    private static int idCounter;
    private int number;
    private String event;
    private String hall;
    private String row;
    private String seat;

    public Booking(String event, String hall, String row, String seat) {
        this.number = idCounter++;
        this.event = event;
        this.hall = hall;
        this.row = row;
        this.seat = seat;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Booking ID: " + number + ", event: " + event + ", hall: " + hall + ", row: " + row + ", seat: " + seat;
    }
}
