package com.threadcreation;

public class ThreadCreation {

    public static void main(String[] args) {

            Thread thread = new MyThread();
            thread.start();

    }

    private static class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hi from " + this.getName());
        }
    }
}


