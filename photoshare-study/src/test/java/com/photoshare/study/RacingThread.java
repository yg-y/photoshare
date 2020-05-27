package com.photoshare.study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RacingThread extends Thread {
    //比赛时间 s
    public Integer time = 10;
    public HorseInfo horse;

    public void setHorseInfo(HorseInfo horse) {
        this.horse = horse;
    }

    public static void main(String[] args) {
        //马匹数量
        Integer horseCount = 8;

        //
        List<Thread> threads = new ArrayList<>();
        for (int i = 1, j = horseCount; i < j; i++) {
            RacingThread racingThread = new RacingThread();
            racingThread.setHorseInfo(new HorseInfo("羊咩咩" + i + "号", racingThread.getSpeed()));
            Thread thread = new Thread(racingThread);
            threads.add(thread);
            thread.start();
        }
    }

    public Integer getSpeed() {
        int max = 100, min = 1;
        int random = (int) (Math.random() * (max - min) + min);
        return random;
    }

    public void startGame() {
        Integer timeCount = 0;
        while (true) {
            System.err.println("马儿名称：" + horse.getName() + ", 速度：" + horse.getSpeed() + "km/s");
            try {
                timeCount += 1;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (timeCount == time) {
                break;
            }
        }
    }

    @Override
    public void run() {
        startGame();
    }
}

class HorseInfo {
    private String name;
    private Integer speed;

    public HorseInfo(String name, Integer speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
