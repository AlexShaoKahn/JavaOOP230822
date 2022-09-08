package com.gmail.kahn.shao.alex.homework.reflectionsexceptions;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Runner {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

        Pair<Object, int[]> pair = new Pair<>(null, new int[0]);

        if (pair.getField1() == null) {
            //throw new NullPointerException();
            System.out.println("throw new NullPointerException()");
        }

        try {
            System.out.println(pair.getField2()[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            //throw new ArrayIndexOutOfBoundsException();
            System.out.println("throw new ArrayIndexOutOfBoundsException()");
        }

        try {
            pair.setField1(1);
            System.out.println((String) pair.getField1());
        } catch (ClassCastException e) {
            //throw new ClassCastException();
            System.out.println("throw new ClassCastException()");
        }

        System.out.println(restoreClassMetaInf(pair, pair.getClass()));
        hackTheObject(pair);
        System.out.println(pair.getS1());
        System.out.println(pair.getS2());
    }

    public static String restoreClassMetaInf(Object obj, Class clazz) throws IllegalAccessException {
        var result = new StringBuilder();
        result.append("Class: ").append(clazz.getSimpleName()).append(System.lineSeparator());
        var fields = clazz.getDeclaredFields();
        result.append("Fields: -------------------").append(System.lineSeparator());
        for (Field field : fields) {
            field.setAccessible(Boolean.TRUE);
            result
                    .append(field.getType().getSimpleName()).append(" ").append(field.getName())
                    .append(" = ").append(field.get(obj)).append(System.lineSeparator());
            field.setAccessible(Boolean.FALSE);
        }
        var methods = clazz.getMethods();
        result.append("Methods: -------------------").append(System.lineSeparator());
        for (Method method : methods) {
            result
                    .append(method.getDeclaringClass().getSimpleName()).append(" ")
                    .append(method.getName())
                    .append("(");
            var params = method.getParameterTypes();
            for (Class<?> param : params) {
                result.append(param.getSimpleName()).append("");
            }
            result
                    .append(");")
                    .append(System.lineSeparator());
        }
        return result.toString();
    }

    public static void hackTheObject(Object obj) throws IllegalAccessException {
        var c = obj.getClass();
        var fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(Boolean.TRUE);
            if (field.getType() == String.class)
                field.set(obj, "You're hacked. Send 10 btc to 34kNXokGAdmLvsJFFZdrkn27PPtvYLXDYS");
        }
    }
}
