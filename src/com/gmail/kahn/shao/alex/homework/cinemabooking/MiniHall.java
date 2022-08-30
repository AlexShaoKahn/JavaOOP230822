package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class MiniHall extends Hall {

    public MiniHall(String hallName) {
        super(5, 5);
        name = hallName;
    }

    @Override
    protected MiniHall clone() {
        return new MiniHall(name);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("Hall: ").append(name).append(System.lineSeparator());
        result.append(super.toString());
        return result.toString();
    }
}
