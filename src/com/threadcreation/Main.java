package com.threadcreation;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("We are in now in "+ Thread.currentThread().getName());
                System.out.println("Current user thread priority "+ Thread.currentThread().getPriority());
            }
        });

        thread.setName("User created thread");

        thread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("We are in thread "+ Thread.currentThread().getName() + " before starting it");
        thread.start();
        System.out.println("We are in thread "+ Thread.currentThread().getName() + " after starting it");

        //Thread.sleep(10000);
    }
}
