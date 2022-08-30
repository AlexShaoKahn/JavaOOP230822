package com.gmail.kahn.shao.alex.homework.cinemabooking;

public class Hall implements Cloneable {
    protected String name = "";
    private Row rows[];

    public Hall(int rowsNumber, int seatsInRowNumber) {
        rows = new Row[rowsNumber];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Row(i + 1, seatsInRowNumber);
        }
    }

    @Override
    protected Hall clone() {
        return new Hall(rows.length, rows[0].getSeats().length);
    }

    public Row[] getRows() {
        return rows;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        for (int i = 0; i < getRows().length; i++) {
            result.append("Row ").append(String.format("%-3d", getRows()[i].getNumber()));
            result.append(getRows()[i].toString()).append(System.lineSeparator());
        }
        return result.toString();
    }

    public String getName() {
        return name;
    }
}
