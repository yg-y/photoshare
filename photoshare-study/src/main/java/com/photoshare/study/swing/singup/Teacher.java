package com.photoshare.study.swing.singup;

public class Teacher {

    private String name;
    private String course;
    private String sex;
    private String phone;

    public Teacher(String name, String course, String sex, String phone) {
        this.name = name;
        this.course = course;
        this.sex = sex;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return
                "科目='" + course + '\'' +
                        ", 姓名='" + name + '\'' +
                        ", 电话='" + phone + '\'' +
                        ", 性别='" + sex;
    }
}
