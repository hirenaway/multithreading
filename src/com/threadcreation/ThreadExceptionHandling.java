package com.threadcreation;

public class ThreadExceptionHandling {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Unexpected exception occurred");
            }
        });

        thread.setName("User misbehaving thread");

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Exception was not caught for " + t.getName() +
                        " the error is " + e.getMessage());
            }
        });

        thread.start();
    }
}
