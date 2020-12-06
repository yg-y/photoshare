package com.photoshare.study.thread;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author young
 * @version 1.0
 * @date 2020/12/7 12:18 上午
 * @description
 */
public class ReentrantLockList {

    // 不安全的 list
    private ArrayList<String> arrayList = new ArrayList<>();

    // 独占锁
    private volatile ReentrantLock lock = new ReentrantLock();

    // add
    public void add(String element) {
        lock.lock();

        try {
            arrayList.add(element);
        } finally {
            lock.unlock();
        }
    }

    // remove
    public void remove(String element) {
        lock.lock();

        try {
            arrayList.remove(element);
        } finally {
            lock.unlock();
        }
    }

    // get
    public String get(int index) {
        lock.lock();

        try {
            return arrayList.get(index);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLockList reentrantLockList = new ReentrantLockList();

        Thread thread1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(300);
                    reentrantLockList.add(i + " element");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(300);
                    reentrantLockList.add(i * 10 + " element");
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(300);
                    reentrantLockList.add(i * 100 + " element");
                }
            }
        });


        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();


        reentrantLockList.arrayList.forEach(System.out::println);
        System.out.println(reentrantLockList.arrayList.size());
    }
}
