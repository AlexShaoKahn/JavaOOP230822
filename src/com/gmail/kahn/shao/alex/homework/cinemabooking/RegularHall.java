package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class RegularHall extends Hall {
    public RegularHall(String hallName) {
        super(20, 40);
        name = hallName;
    }

    @Override
    protected RegularHall clone() {
        return new RegularHall(name);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("Hall: ").append(name).append(System.lineSeparator());
        result.append(super.toString());
        return result.toString();
    }
}
