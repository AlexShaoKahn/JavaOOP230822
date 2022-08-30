package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class FourDHall extends Hall {
    public FourDHall(String hallName) {
        super(10, 20);
        name = hallName;
    }

    @Override
    protected FourDHall clone() {
        return new FourDHall(name);
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append("Hall: ").append(name).append(System.lineSeparator());
        result.append(super.toString());
        return result.toString();
    }
}
