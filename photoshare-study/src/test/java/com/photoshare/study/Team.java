package com.photoshare.study;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Team {
    static List<Student> students = new ArrayList<>();

    public Team(List<Student> students) {
        Team.students = students;
    }

    public static void add(Student student) {
        students.add(student);
    }

    public static void remove(Student student) {
        students.remove(student);
    }

    public void print() {
        students = Student.comparable(students);
        List<String> collect = students.stream().map(s -> s.getTeamName()).distinct().collect(Collectors.toList());
        List<TreeMap> prints = new ArrayList<>();

        for (String s : collect) {
            StringBuffer stringBuffer = new StringBuffer();
            String group = null;
            TreeMap map = new TreeMap<String, String>();
            for (Student student : students) {
                if (s.equals(student.getTeamName())) {
                    stringBuffer.append(student.getName() + " ");
                }
                group = s;
            }
            map.put(group, stringBuffer);
            prints.add(map);
        }
        prints.forEach(System.out::println);
    }


    public static void main(String[] args) {
        for (int i = 0, j = 10; i < j; i++) {
            Student student = new Student();
            student.setId("1");
            Double d = Math.random() * 10;
            student.setName("学生" + d.intValue());
            student.setTeamName("group1");
            Team.add(student);
        }

        for (int i = 0, j = 10; i < j; i++) {
            Student student = new Student();
            student.setId("1");
            Double d = Math.random() * 10;
            student.setName("学生" + d.intValue());
            student.setTeamName("group2");
            Team.add(student);
        }

        Team team = new Team(Team.students);
        team.print();
    }
}
