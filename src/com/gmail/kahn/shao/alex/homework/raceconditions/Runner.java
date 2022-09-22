package com.gmail.kahn.shao.alex.homework.raceconditions;

public class Runner {
    private static long counter1;
    private static long counter2;
    private static Object lock2 = new Object();

    public static void main(String[] args) throws InterruptedException {

        int times = 1000000;
        int threads = 5;

        for (int i = 1; i <= threads; i++) {
            var thread = new Thread(() -> {
                for (int j = 0; j < times; j++) {
                    counter1++;
                    synchronized (lock2) {
                        counter2++;
                    }
                }
            });
            thread.start();
            if (i == threads) thread.join();
        }

        System.out.print("Expected: " + times * threads + ", actual: " + counter1);
        System.out.println(", synchronized: " + counter2);
    }
}
