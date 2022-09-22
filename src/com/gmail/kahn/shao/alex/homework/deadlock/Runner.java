package com.gmail.kahn.shao.alex.homework.deadlock;

public class Runner {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " has begun");

        Object[] locks = new Object[]{new Object(), new Object(), new Object()};

        for (int i = 0; i < locks.length; i++) {
            int lockNumber = i;
            new Thread(() -> {
                synchronized (locks[lockNumber]) {
                    System.out.println(Thread.currentThread().getName() + " going to sleep");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + " woke up");
                    synchronized (locks[lockNumber + 1 == locks.length ? 0 : lockNumber + 1]) {
                        System.out.println(Thread.currentThread().getName() + " ended");
                    }
                }
            }).start();
        }
        System.out.println(Thread.currentThread().getName() + " ended");
    }
}
