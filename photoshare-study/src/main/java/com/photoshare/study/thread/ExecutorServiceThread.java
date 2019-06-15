package com.photoshare.study.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author:Young
 * @Description 线程池
 * @Date: 2019/6/15 0015 11:05
 */
public class ExecutorServiceThread {


    public static void main(String args[]) {

        List<String> list = new ArrayList<>();

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        //Common Thread Pool
        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                10L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0, j = 10; i < j; i++) {
            int finalI = i;
            pool.execute(() -> add(list, String.valueOf(finalI)));
        }

        pool.shutdown();

        while (true) {

            try {
                pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.err.println(pool.isTerminated() + " : " + String.valueOf(System.currentTimeMillis()));

            if (pool.isTerminated()) {
                System.err.println(list);
                break;
            }
        }

    }

    public static void add(List<String> list, String index) {
        try {
            Thread.sleep(Long.parseLong("1000"));
            list.add(index);
            System.err.println("run is " + index + "...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
