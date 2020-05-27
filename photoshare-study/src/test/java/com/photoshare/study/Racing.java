package com.photoshare.study;

import java.util.HashMap;
import java.util.Map;

public class Racing implements Runnable {

    private Map<String, String> horse = new HashMap<>();
    private Integer racingDate = 0;

    public Map<String, String> getHorse() {
        return horse;
    }

    public void setHorse(Map<String, String> horse) {
        this.horse = horse;
    }

    public Integer getRacingDate() {
        return racingDate;
    }

    public void setRacingDate(Integer racingDate) {
        this.racingDate = racingDate;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (horse.entrySet().isEmpty()) {
                System.out.println("没有马儿");
            }
            // 随机速度
            int speed = (int) (Math.random() * 100);
            System.err.println(horse.get("name") + ":速度" + speed);
            count += 1;
            if (count == racingDate) {
                break;
            }
        }

    }

}

class RacingTest {

    public static void main(String[] args) {
        System.out.println("==========比赛开始=========");
        for (int i = 1, j = 5; i < j; i++) {
            Racing racing = new Racing();
            racing.setRacingDate(10);
            Map<String, String> horse = new HashMap<>();
            horse.put("name", "马儿" + i);

            racing.setHorse(horse);

            Thread thread = new Thread(racing);
            thread.start();
        }
    }
}

