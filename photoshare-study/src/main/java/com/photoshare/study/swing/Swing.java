package com.photoshare.study.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;


/**
 * 给出两个随机数算结果判断正确且可导出结果窗体程序
 */
public class Swing extends JFrame implements Runnable {
    private static final long serialVersionUID = 1618163380623777731L;

    static final Integer WIDTH = 600;
    static final Integer HEIGHT = 500;

    static Integer NUMBER_1 = 0;
    static Integer NUMBER_2 = 0;
    static String CALCULATE_RESULT = null;
    static String CALCULATE_RESULT_EXPORT = null;
    static Integer NUMBER_MAX = 100;
    static Integer NUMBER_MIN = 0;
    static Integer NUMBER_COUNTDOWN = 60;

    JLabel countdown = new JLabel();
    JButton jButton = new JButton("计算");
    JButton jButtonNext = new JButton("下一题");
    JButton jButtonExport = new JButton("导出结果");

    //随机数的第一个框
    JTextField random1 = new JTextField(20);
    //随机数的第二个框
    JTextField random2 = new JTextField(20);
    //用户输入的结果
    JTextField result = new JTextField();
    //统计学生输入的结果展示框
    JTextArea resultExport = new JTextArea();

    //创建当前线程
    Thread thread = new Thread(this);

    StringBuffer text = new StringBuffer();

    /**
     * 换成你的背景图片地址
     */
    static String filePath = "/Users/young/IdeaProjects/photoshare/photoshare-study/src/main/java/com/photoshare/study/swing/";

    public static void main(String[] args) {
        new Swing();
    }

    public Swing() {
        this.setTitle("二位整数运算");
        //不采用任何布局方式。
        this.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        //这是背景图片
        ImageIcon img = new ImageIcon(filePath + "WechatIMG608.jpg");
        //将背景图放在标签里。
        JLabel imgLabel = new JLabel(img);
        //注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
        //注意这里是关键，将背景标签添加到jfram的LayeredPane面板里。
        imgLabel.setBounds(0, 0, WIDTH, HEIGHT);

        jPanel.setOpaque(false);
        this.setContentPane(jPanel);

        //初始化计算
        initNumber();

        //创建第一个输入框
        random1.setBounds(10, 20, 100, 50);
        random1.setText(String.valueOf(NUMBER_1));
        jPanel.add(random1);

        JLabel jLabel = new JLabel("+");
        jLabel.setBounds(130, 20, 10, 50);
        jPanel.add(jLabel);

        //创建第2个输入框
        random2.setBounds(170, 20, 100, 50);
        random2.setText(String.valueOf(NUMBER_2));
        jPanel.add(random2);

        JLabel jLabelResult = new JLabel("=");
        jLabelResult.setBounds(290, 20, 10, 50);
        jPanel.add(jLabelResult);

        //创建第3个输入框
        result.setBounds(310, 20, 100, 50);
        result.setText(CALCULATE_RESULT);
        jPanel.add(result);

        //创建统计结果输入框
        resultExport.setBounds(10, 100, 520, 200);
        resultExport.setText(CALCULATE_RESULT_EXPORT);
        jPanel.add(resultExport);

        //创建倒计时
        countdown.setBounds(10, 400, 400, 50);
        thread.start();
        jPanel.add(countdown);

        //创建计算按钮
        jButton.setBounds(430, 20, 100, 50);
        jPanel.add(jButton);

        //导出结果按钮
        jButtonExport.setBounds(10, 330, 100, 50);
        jPanel.add(jButtonExport);

        //下一题
        jButtonNext.setBounds(400, 330, 100, 50);
        jPanel.add(jButtonNext);


        this.setSize(WIDTH, HEIGHT);
        this.setLocation(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //点击下一题
        jButtonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //停止当前线程
                NUMBER_COUNTDOWN = 0;
                //初始化数据
                initNumber();
                //将计算按钮设为可见
                jButton.setVisible(true);
                //重新启动计算时长的线程
                thread.start();
            }
        });

        //计算按钮
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String context = "\n";
                try {
                    // 获取输入框中的值
                    Integer numberResult = Integer.valueOf(result.getText());
                    Integer number1 = Integer.valueOf(random1.getText());
                    Integer number2 = Integer.valueOf(random2.getText());

                    // 计算数值
                    if (numberResult == (number1 + number2)) {
                        context = number1 + " + " + number2 + " = " + numberResult + " , 答对了，真棒。\n";
                    } else {
                        context = number1 + " + " + number2 + " = " + numberResult + " , 请在答一次。\n";
                    }
                } catch (Exception ex) {
                    text.append("数据输入出错\n");
                }
                text.append(context);
                resultExport.setText(String.valueOf(text));
            }
        });

        /**
         * 导出结果
         */
        jButtonExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NUMBER_COUNTDOWN = 0;
                jButton.setVisible(false);
                jButtonNext.setVisible(false);
                System.err.println(resultExport.getText());
                StringBuffer stringBuffer = new StringBuffer(resultExport.getText());
                String[] split1 = stringBuffer.toString().split("答对了，真棒。");
                String[] split2 = stringBuffer.toString().split("请在答一次。");

                stringBuffer.append("\n答对次数：" + (split1.length - 1));
                stringBuffer.append("\n答错次数：" + (split2.length - 1));
                saveExportFile(String.valueOf(stringBuffer), filePath + "/file", "statistical.txt");
            }
        });
    }

    /**
     * 初始化数值
     */
    private void initNumber() {
        Random random = new Random();
        NUMBER_1 = random.nextInt(NUMBER_MAX) % (NUMBER_MAX - NUMBER_MIN + 1) + NUMBER_MIN;
        NUMBER_2 = random.nextInt(NUMBER_MAX) % (NUMBER_MAX - NUMBER_MIN + 1) + NUMBER_MIN;
        NUMBER_COUNTDOWN = 60;
        random1.setText(String.valueOf(NUMBER_1));
        random2.setText(String.valueOf(NUMBER_2));
        result.setText(null);
    }

    /**
     * 倒计时计算
     *
     * @param countdown
     */
    private void countdownMethod(JLabel countdown) {
        if (NUMBER_COUNTDOWN == 0) {
            NUMBER_COUNTDOWN = 60;
            countdown.setText("倒计时：时间到了");
            jButton.setVisible(false);
            return;
        }
        try {
            // 睡眠 1s 执行
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println("thread exception ： " + e.getMessage());
        }
        System.err.println("倒计时：剩余时间 " + NUMBER_COUNTDOWN + " 秒");
        NUMBER_COUNTDOWN--;
        countdown.setText("倒计时：剩余时间 " + NUMBER_COUNTDOWN + " 秒");
        countdownMethod(countdown);
        return;
    }

    /**
     * 实现 run 方法
     */
    @Override
    public void run() {
        countdownMethod(countdown);
    }

    /**
     * 保存文件到本地
     *
     * @param result
     * @param outPath
     * @param outPath
     * @throws Exception
     */
    public static void saveExportFile(String result, String outPath, String outFileName) {
        try {
            // 该文件夹为空则创建一个文件夹
            File dir = new File(outPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File txt = new File(outPath + "/" + outFileName);
            if (!txt.exists()) {
                txt.createNewFile();
            }
            byte bytes[] = new byte[512];
            bytes = result.getBytes();
            // 是字节的长度，不是字符串的长度
            int b = bytes.length;
            FileOutputStream fos = new FileOutputStream(txt);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (IOException e) {
        }
    }
}
