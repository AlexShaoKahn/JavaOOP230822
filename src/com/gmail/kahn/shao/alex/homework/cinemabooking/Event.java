package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class Event {
    private String name;
    private Hall hall;

    public Event(String eventName, Hall hall) {
        this.name = eventName;
        this.hall = hall.clone();
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result
                .append("Event: ").append(name).append(System.lineSeparator())
                .append(hall.toString());
        return result.toString();
    }

    public Hall getHall() {
        return hall;
    }

    public String getName() {
        return name;
    }
}
