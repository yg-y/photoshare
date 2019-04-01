package com.photoshare.study.thread;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.err.println("created new thread , running ...");
        }

    }

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        ThreadTest2 threadTest2 = new ThreadTest2();
        Thread thread = new Thread(threadTest2);
        thread.start();
        threadTest.start();
    }
}

class ThreadTest2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
            System.err.println("created new thread two, running ...");
        }
    }
}
