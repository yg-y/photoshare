package com.photoshare.study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HorseGame extends Thread {
    // 比赛时间 单位 秒
    public Integer TIME = 0;
    // 比赛的马匹
    public Horse HORSE;

    public void setGameTime(Integer time) {
        TIME = time;
    }

    public void setHorse(Horse horse) {
        HORSE = horse;
    }

    public static void main(String[] args) {

        //比赛时间
        Integer startTime = 8;
        //马匹数量
        Integer horseCount = 8;

        //
        List<Thread> threads = new ArrayList<>();
        for (int i = 1, j = horseCount; i < j; i++) {
            HorseGame horseGame = new HorseGame();
            horseGame.setGameTime(startTime);
            horseGame.setHorse(new Horse("银河" + i + "号", horseGame.getSpeed()));
            Thread thread = new Thread(horseGame);
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        boolean target = true;
        while (true) {
            for (Thread thread : threads) {
                if (!thread.isAlive()) {
                    target = false;
                    continue;
                }
                target = true;
            }
            if (!target) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }


        while (true) {
            if (!target) {
                Horse horse = Result.result.stream().max(Comparator.comparingInt(Horse::getDistance)).get();
                System.err.println("第一名: " + horse.getName() + "跑了：" + horse.getDistance() + ",它的速度是" + horse.getSpeed() + "km/s");
                break;
            }
            System.err.println("等待线程执行完毕...");
        }
    }

    public Integer getSpeed() {
        int max = 100, min = 1;
        int random = (int) (Math.random() * (max - min) + min);
        return random;
    }

    public void startGame() {
        Integer count = 0;
        Integer timeCount = 0;
        while (true) {
            if (TIME == 0) {
                System.out.println("没有设置时间");
                break;
            }
            if (HORSE == null) {
                System.out.println("没有马匹");
                break;
            }
            count += HORSE.getSpeed();
            System.err.println(HORSE.getName() + ", 速度：" + HORSE.getSpeed() + "km/s, 跑了: " + count + " km");
            try {
                timeCount += 1;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (timeCount == TIME) {
                synchronized (HORSE) {
                    HORSE.setDistance(count);
                    Result.result.add(HORSE);
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        startGame();
    }
}

class Result {
    public static volatile List<Horse> result = new ArrayList<>();
}

class Horse {
    private String name;
    private Integer speed;
    private Integer distance;

    public Horse(String name, Integer speed) {
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
