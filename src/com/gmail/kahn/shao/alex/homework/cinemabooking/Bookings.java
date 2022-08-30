package com.gmail.kahn.shao.alex.homework.cinemabooking;

import java.util.HashMap;
import java.util.Map;

public class Bookings {
    private Map<Integer, Booking> bookings;

    public Bookings() {
        bookings = new HashMap<>();
    }

    public int addBooking(Event event, int rowNumber, int seatNumber) {
        Booking booking = new Booking(
                event.getName(),
                event.getHall().getName(),
                String.valueOf(event.getHall().getRows()[rowNumber - 1].getNumber()),
                String.valueOf(event.getHall().getRows()[rowNumber - 1].getSeats()[seatNumber - 1].getNumber())
        );
        if (!event.getHall().getRows()[rowNumber - 1].getSeats()[seatNumber - 1].isFree()) return -1;
        event.getHall().getRows()[rowNumber - 1].getSeats()[seatNumber - 1].setFree(Boolean.FALSE);
        bookings.put(booking.getNumber(), booking);
        return booking.getNumber();
    }

    public int bookFreeSeat(Event event) {
        var rows = event.getHall().getRows();
        for (int i = 0; i < rows.length; i++) {
            var seats = rows[i].getSeats();
            for (int j = 0; j < seats.length; j++) {
                if (seats[j].isFree()) return addBooking(event, i + 1, j + 1);
            }
        }

        return -1;
    }

    public Booking getBooking(int id) {
        return bookings.get(id);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        bookings.forEach((k, v) -> System.out.println(v));
        return result.toString();
    }
}
