package com.photoshare.study;

import java.util.concurrent.*;

public class RacingExecutor {
    //自定义比赛时间
    public static int dateTime = 10;

    public static void main(String[] args) {
        //创建线程池
        long currentTimeMillis = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for (int i = 1, j = 10; i < j; i++) {
            int finalI = i;
            executorService.execute(() -> run("钻石" + finalI + "号"));
        }
        executorService.shutdown();
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (executorService.isTerminated()) {
                System.out.println("比赛结束，总耗时：" + (System.currentTimeMillis() - currentTimeMillis) / 1000);
                break;
            }
        }
    }

    public static void run(String name) {
        int timeCount = 0;
        while (true) {

            timeCount += 1;
            if (timeCount == dateTime) {
                break;
            }
            System.err.println(name + ",当前马儿速度：" + (int) (Math.random() * 300));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
