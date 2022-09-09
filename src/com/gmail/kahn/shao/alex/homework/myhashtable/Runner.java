package com.gmail.kahn.shao.alex.homework.myhashtable;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        //MyAutoSizableArray
        var autoSizableArray = new MyAutoSizableArray<Integer>();

        //Filling AutoSizableArray
        var array = getRandomIntsArray(5, 5);
        System.out.println("Adding to array: " + Arrays.toString(array));
        autoSizableArray.addAll(array);
        array = getRandomIntsArray(6, 5);
        System.out.println("Adding to array: " + Arrays.toString(array));
        autoSizableArray.addAll(array);
        array = getRandomIntsArray(7, 5);
        System.out.println("Adding to array: " + Arrays.toString(array));
        autoSizableArray.addAll(array);

        //Printing AutoSizableArray
        System.out.println("AutoSizableArray: " + autoSizableArray);

        //Adding element
        System.out.print("Add element: ");
        autoSizableArray.add(scanner.nextInt());
        System.out.println("AutoSizableArray: " + autoSizableArray);

        //Removing element
        System.out.print("Remove element by index: ");
        autoSizableArray.remove(scanner.nextInt());
        System.out.println("AutoSizableArray: " + autoSizableArray);

        System.out.println();

        //MyHashTable
        var hashArray = new MyHashTable<Integer>();
        System.out.println(hashArray.size());

        //Filling HashTable
        array = getRandomIntsArray(5, 20);
        System.out.println("Adding to HashTable: " + Arrays.toString(array));
        hashArray.addAll(array);
        array = getRandomIntsArray(6, 20);
        System.out.println("Adding to HashTable: " + Arrays.toString(array));
        hashArray.addAll(array);
        array = getRandomIntsArray(7, 20);
        System.out.println("Adding to HashTable: " + Arrays.toString(array));
        hashArray.addAll(array);

        //Printing Hashtable
        System.out.print("HashTable: ");
        System.out.println(hashArray);

        //Contains
        System.out.print("Contains number?: ");
        System.out.println(hashArray.contains(scanner.nextInt()) ? "ok" : "not found");

        //Delete element
        System.out.print("Delete element: ");
        System.out.println(hashArray.remove(scanner.nextInt()) ? "ok" : "not found");

        //Printing Hashtable
        System.out.print("HashTable: ");
        System.out.println(hashArray);

        scanner.close();
    }

    private static Integer[] getRandomIntsArray(int size, int bound) {
        var random = new Random();
        var array = new Integer[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}
