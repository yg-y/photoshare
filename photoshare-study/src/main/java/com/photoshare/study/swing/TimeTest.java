package com.photoshare.study.swing;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * 时钟窗体程序
 */
public class TimeTest {

    public static final Integer HOUR_TIME = 23;
    public static final Integer MINUTES_TIME = 59;
    public static final Integer SECONDS_TIME = 59;

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        //定义小时
        Integer hour = 0;
        //定义分钟
        Integer minutes = 0;
        //定义秒
        Integer seconds = 0;

        // 控制台输入时分
        while (true) {
            System.err.println("请输入小时：");
            hour = Integer.valueOf(scanner.next());

            System.err.println("请输入分钟：");
            minutes = Integer.valueOf(scanner.next());

            break;
        }

        // 创建时钟显示窗体
        JFrame jFrame = new JFrame("时钟");
        jFrame.setSize(250, 100);
        jFrame.setLocation(500, 500);
        jFrame.setLayout(new BorderLayout());
        JLabel timeLabel = new JLabel();
        timeLabel.setBounds(60, 10, 200, 50);
        timeLabel.setFont(new Font(null, Font.PLAIN, 15));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        jPanel.setOpaque(false);
        jPanel.add(timeLabel);
        jFrame.setContentPane(jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        String outHour;
        String outMinutes;
        String outSeconds;
        String time;

        //时间计算
        while (true) {
            if (seconds < SECONDS_TIME) {
                seconds++;
            } else {
                seconds = 0;
                if (minutes < MINUTES_TIME) {
                    minutes++;
                } else {
                    minutes = 0;
                    if (hour < HOUR_TIME) {
                        hour++;
                    } else {
                        seconds = 0;
                        minutes = 0;
                        hour = 0;
                    }
                }
            }

            outHour = String.valueOf(hour);
            outMinutes = String.valueOf(minutes);
            outSeconds = String.valueOf(seconds);
            if (hour < 10) {
                outHour = "0" + hour;
            }
            if (minutes < 10) {
                outMinutes = "0" + minutes;
            }
            if (seconds < 10) {
                outSeconds = "0" + seconds;
            }
            time = (outHour + " 时 " + outMinutes + " 分 " + outSeconds + " 秒");
            System.err.println(time);
            timeLabel.setText(time);
            Thread.sleep(1000);
        }
    }
}
