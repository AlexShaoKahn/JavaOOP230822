package com.gmail.kahn.shao.alex.homework.cinemabooking;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private final String NAME = "Super Movies";
    private Hall regularHall;
    private Hall fourDHall;
    private Hall miniHall;
    private List<Event> events;
    private Bookings bookings;

    public Cinema() {
        regularHall = new RegularHall("Regular");
        fourDHall = new FourDHall("4D");
        miniHall = new MiniHall("Mini");
        events = new ArrayList<>();
        bookings = new Bookings();
    }

    public Bookings getBookings() {
        return bookings;
    }

    public Booking getBookings(int id) {
        return bookings.getBooking(id);
    }

    public Hall getRegularHall() {
        return regularHall;
    }

    public Hall getFourDHall() {
        return fourDHall;
    }

    public Hall getMiniHall() {
        return miniHall;
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getNAME() {
        return NAME;
    }
}
