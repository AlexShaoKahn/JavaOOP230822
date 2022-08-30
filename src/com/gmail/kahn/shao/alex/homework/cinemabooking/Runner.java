package com.gmail.kahn.shao.alex.homework.cinemabooking;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        cinema.getEvents().add(new Event("Spiderman", cinema.getRegularHall()));
        cinema.getEvents().add(new Event("Terminator", cinema.getFourDHall()));
        cinema.getEvents().add(new Event("Star Wars", cinema.getMiniHall()));

        //booking a specific seat for a specific event
        System.out.println(cinema.getEvents().get(2));
        cinema.getBookings().addBooking(cinema.getEvents().get(2), 3, 3);
        cinema.getBookings().addBooking(cinema.getEvents().get(2), 3, 4);
        cinema.getBookings().addBooking(cinema.getEvents().get(2), 3, 5);
        cinema.getBookings().addBooking(cinema.getEvents().get(2), 1, 1);
        cinema.getBookings().addBooking(cinema.getEvents().get(2), 1, 2);
        cinema.getBookings().addBooking(cinema.getEvents().get(2), 1, 3);
        System.out.println(cinema.getBookings());
        System.out.println(cinema.getEvents().get(2));

        //booking the first available seat for any event
        var random = new Random();
        cinema.getBookings().bookFreeSeat(cinema.getEvents().get(random.nextInt(cinema.getEvents().size())));
        cinema.getBookings().bookFreeSeat(cinema.getEvents().get(random.nextInt(cinema.getEvents().size())));
        cinema.getBookings().bookFreeSeat(cinema.getEvents().get(random.nextInt(cinema.getEvents().size())));
        cinema.getBookings().bookFreeSeat(cinema.getEvents().get(random.nextInt(cinema.getEvents().size())));
        System.out.println(cinema.getBookings());
    }
}
