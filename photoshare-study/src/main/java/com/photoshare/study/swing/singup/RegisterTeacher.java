package com.photoshare.study.swing.singup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterTeacher extends JFrame {

    static final Integer WIDTH = 600;
    static final Integer HEIGHT = 500;

    static int count = 0;

    JLabel title = new JLabel("教师注册");
    JLabel name = new JLabel("姓名");
    JLabel course = new JLabel("课程");
    JLabel phone = new JLabel("电话");
    JLabel sex = new JLabel("性别");

    JTextField nameText = new JTextField(10);
    String[] courseResult = {"Java程序设计", "Photoshop", "操作系统"};
    JComboBox courseComboBox = new JComboBox(courseResult);

    JTextField phoneText = new JTextField(10);

    JRadioButton boy = new JRadioButton("男", true);
    JRadioButton girl = new JRadioButton("女");

    ButtonGroup sexGroup = new ButtonGroup();

    JButton signUp = new JButton("注册");

    public RegisterTeacher() {
        this.setTitle("教师信息注册（学号-姓名）");
        //不采用任何布局方式。
        this.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);

        jPanel.setOpaque(false);
        this.setContentPane(jPanel);

        // 初始化注册教师数
        count = 0;

        // 设置按钮及布局
        title.setBounds(250, 10, 100, 50);
        title.setFont(new Font(null, Font.PLAIN, 20));
        jPanel.add(title);

        name.setBounds(100, 70, 50, 50);
        name.setFont(new Font(null, Font.PLAIN, 15));
        jPanel.add(name);

        nameText.setBounds(170, 70, 300, 45);
        // 设置默认值
        nameText.setText("张三");
        jPanel.add(nameText);

        course.setBounds(100, 130, 50, 50);
        course.setFont(new Font(null, Font.PLAIN, 15));
        jPanel.add(course);

        courseComboBox.setBounds(170, 130, 300, 50);
        jPanel.add(courseComboBox);

        phone.setBounds(100, 190, 50, 50);
        phone.setFont(new Font(null, Font.PLAIN, 15));
        jPanel.add(phone);

        phoneText.setBounds(170, 190, 300, 45);
        phoneText.setText("1234567891011");
        jPanel.add(phoneText);

        sex.setBounds(100, 250, 50, 50);
        sex.setFont(new Font(null, Font.PLAIN, 15));
        jPanel.add(sex);

        sexGroup.add(boy);
        sexGroup.add(girl);
        boy.setBounds(170, 250, 50, 50);
        girl.setBounds(230, 250, 50, 50);
        jPanel.add(boy);
        jPanel.add(girl);

        signUp.setBounds(250, 350, 150, 50);
        jPanel.add(signUp);

        // 设置窗口大小及出现位置
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        jPanel.setOpaque(false);


        // 注册点击事件
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "注册成功", "消息", JOptionPane.PLAIN_MESSAGE);
                String nameResult = nameText.getText();
                String courseResult = (String) courseComboBox.getSelectedItem();
                String phoneResult = phoneText.getText();
                String sexResult = boy.isSelected() ? "男" : "女";

                Teacher teacher = new Teacher(nameResult, courseResult, sexResult, phoneResult);
                count += 1;
                System.out.println("教师" + count);
                System.out.println(teacher.toString());
            }
        });
    }
}
