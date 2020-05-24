package com.photoshare.study.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        Calculator jsq = new Calculator();
    }

    JTextField result_TextField;
    int count = 1;
    double result = 0.0;//承接结果
    String cmdString = "=";//初始符号，用来记录输入的第一个数字
    boolean start = true;
    boolean operateValidFlag = true;
    boolean operate = true;//判断运算是否合法

    public Calculator()//构造函数进行计算其界面的布局
    {
        result_TextField = new JTextField(20);
        result_TextField.setHorizontalAlignment(JTextField.RIGHT);
        JButton clear_Button = new JButton("clear");
        JButton button0 = new JButton("0");
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");
        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");
        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        JButton button_Dian = new JButton(".");
        JButton button_Jia = new JButton("+");
        JButton button_Jian = new JButton("-");
        JButton button_Cheng = new JButton("*");
        JButton button_Chu = new JButton("/");
        JButton button_Dy = new JButton("=");
        JButton button_kaiFang = new JButton("√");
        JButton button_daoShu = new JButton("1/x");
        JButton button_Time = new JButton("Time");
        JButton button_sin = new JButton("sin");
        JButton button_cos = new JButton("cos");
        JButton button_tan = new JButton("tan");
        JButton button_third_power = new JButton("^3");

        JPanel pan = new JPanel();
        JPanel pan2 = new JPanel();

        pan.setLayout(new GridLayout(4, 4, 5, 5));
        pan.add(button_sin);
        pan.add(button_Time);
        pan.add(button7);
        pan.add(button8);
        pan.add(button9);
        pan.add(button_Chu);
        pan.add(button_cos);
        pan.add(button_kaiFang);
        pan.add(button4);
        pan.add(button5);
        pan.add(button6);
        pan.add(button_Cheng);
        pan.add(button_tan);
        pan.add(button_daoShu);
        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button_Jian);
        pan.add(button_third_power);
        pan.add(clear_Button);
        pan.add(button_Dian);
        pan.add(button0);
        pan.add(button_Dy);
        pan.add(button_Jia);
        pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pan2.add(result_TextField, BorderLayout.WEST);
        //pan2.add(clear_Button,BorderLayout.EAST);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button_Chu.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button_Cheng.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button_Jian.addActionListener(this);
        button0.addActionListener(this);
        button_Dian.addActionListener(this);
        button_Dy.addActionListener(this);
        button_Jia.addActionListener(this);
        clear_Button.addActionListener(this);
        button_daoShu.addActionListener(this);
        button_Time.addActionListener(this);
        button_kaiFang.addActionListener(this);
        button_third_power.addActionListener(this);
        button_sin.addActionListener(this);
        button_cos.addActionListener(this);
        button_tan.addActionListener(this);

        this.add(pan2, BorderLayout.NORTH);
        this.add(pan, BorderLayout.CENTER);
        this.setLocation(500, 400);
        this.setResizable(false);
        this.pack();
        this.setTitle("计算器");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {//监听总函数
        // TODO Auto-generated method stub
        String intputString = e.getActionCommand();
        if (intputString.equals("+") || intputString.equals("-") || intputString.equals("*") || intputString.equals("/") || intputString.equals("=")) {//yunsuanfu
            handleYs(intputString);
        } else if (intputString.equals("clear")) {//qingchu
            handleC();
        } else if (intputString.equals("Time")) {
            handleTime();
        } else if (intputString.equals("√")) {
            handleKf();
        } else if (intputString.equals("1/x")) {
            handleDs();
        } else if (intputString.equals("tan")) {
            handleTan();
        } else if (intputString.equals("cos")) {
            handleCos();
        } else if (intputString.equals("sin")) {
            handleSin();
        } else if (intputString.equals("^3")) {
            handleThree();
        } else {//shuzihexioshudain
            handleSz(intputString);
        }
    }

    private void handleThree() {
        String text = result_TextField.getText();
        double radians = Double.parseDouble(text);
        result_TextField.setText(String.valueOf(radians * radians * radians));
    }

    private void handleSin() {
        String text = result_TextField.getText();
        double radians = Math.toRadians(Double.parseDouble(text));
        result_TextField.setText(String.valueOf(Math.sin(radians)));
    }

    private void handleCos() {
        String text = result_TextField.getText();
        double radians = Math.toRadians(Double.parseDouble(text));
        result_TextField.setText(String.valueOf(Math.cos(radians)));
    }

    private void handleTan() {
        String text = result_TextField.getText();
        double radians = Math.toRadians(Double.parseDouble(text));
        result_TextField.setText(String.valueOf(Math.tan(radians)));
    }

    public void handleC() {//清除键函数
        result_TextField.setText("0");
        start = true;
        cmdString = "=";
    }

    public void handleSz(String keyString) {//数字和小数点函数
        if (start) {
            result_TextField.setText(keyString);
        } else if (keyString.equals(".") && count == 1) {
            result_TextField.setText(result_TextField.getText() + keyString);
            count++;
        } else if (!keyString.equals(".")) {
            result_TextField.setText(result_TextField.getText() + keyString);
        }
        start = false;
    }

    public void handleYs(String fh) {//运算符函数
        if (cmdString.equals("+")) {
            result += Double.parseDouble(result_TextField.getText());
        } else if (cmdString.equals("-")) {
            result -= Double.parseDouble(result_TextField.getText());
        } else if (cmdString.equals("*")) {
            result *= Double.parseDouble(result_TextField.getText());
        } else if (cmdString.equals("/")) {
            if (Double.parseDouble(result_TextField.getText()) == 0) {
                operate = false;
                result_TextField.setText("cuowu");
                System.out.println(33333333);
            } else {
                result /= Double.parseDouble(result_TextField.getText());
            }
        } else if (cmdString.equals("=")) {
            result = Double.parseDouble(result_TextField.getText());
        }

        if (operate) {
            result_TextField.setText(String.valueOf(result));
        }
        cmdString = fh;
        start = true;
        count = 1;
        operate = true;

    }

    public void handleKf() {
        if (Double.parseDouble(result_TextField.getText()) < 0) {
            result_TextField.setText("负数不能开方");
        } else {
            result_TextField.setText(String.valueOf(Math.sqrt(Double.parseDouble(result_TextField.getText()))));
        }
        start = true;
    }

    public void handleDs() {
        if (Double.parseDouble(result_TextField.getText()) == 0) {
            result_TextField.setText("0,没有导数");
        } else {
            result_TextField.setText(String.valueOf(1 / Double.parseDouble(result_TextField.getText())));
        }
        start = true;
    }

    public void handleTime() {
        result_TextField.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
