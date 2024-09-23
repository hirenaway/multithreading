package com.threadcreation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaseStudy {

    public static final int PASSWORD = 8988888;

    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(PASSWORD));

        List<Thread> threads = new ArrayList<>();
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());

        for(Thread thread : threads){
            thread.start();
        }

    }

    private static class Vault {
        private int guess;

        public Vault(int guess){
            this.guess = guess;
        }

        public boolean isCorrectPassword(int guess){
            try{
                Thread.sleep(5);
            } catch (Exception e){
            }
            return this.guess == guess;
        }
    }
    private static abstract class HackerThread extends Thread {
        protected Vault vault;

        public HackerThread(Vault vault){
            this.vault = vault;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }

        @Override
        public void start() {
            System.out.println("Starting thread " + this.getName());
            super.start();
        }
    }

    private static class AscendingHackerThread extends HackerThread {

        public AscendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i = 0; i < PASSWORD; i++){
                if(vault.isCorrectPassword(i)){
                    System.out.println("this thread " + this.getName() + "guessed the password " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class DescendingHackerThread extends HackerThread {

        public DescendingHackerThread(Vault vault) {
            super(vault);
        }

        @Override
        public void run() {
            for(int i = PASSWORD; i >= 0; i--){
                if(vault.isCorrectPassword(i)){
                    System.out.println("this thread " + this.getName() + "guessed the password " + i);
                    System.exit(0);
                }
            }
        }
    }

    private static class PoliceThread extends Thread {

        @Override
        public void run() {
            for (int i = 10; i > 0; i--){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(i);
            }
            System.out.println("Hands up hackers");
            System.exit(0);
        }
    }
}
