package com.gmail.kahn.shao.alex.homework.reflectionsexceptions;

public class Pair<T1, T2> {
    private T1 field1;
    private T2 field2;
    private String s1;
    private String s2;

    public Pair(T1 field1, T2 field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public Pair() {
    }

    public T1 getField1() {
        return field1;
    }

    public T2 getField2() {
        return field2;
    }

    public void setField1(T1 field1) {
        this.field1 = field1;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }
}
