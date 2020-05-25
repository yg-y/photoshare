package com.photoshare.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountList {

    //编号计数器
    static Integer count = 0;
    //创建财务记录
    static List<Bill> bills = new ArrayList<>();
    //创建用途分类
    static String[] uses = {"学习", "餐饮", "出行", "娱乐", "服饰", "旅游"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("====================欢迎使用记账清单系统====================");
        menu(scanner);
    }

    /**
     * 菜单
     *
     * @param scanner
     */
    private static void menu(Scanner scanner) {
        System.err.println("1：显示所有记录");
        System.err.println("2：添加记录");
        System.err.println("3：删除记录");
        System.err.println("4：按用途查询");
        System.err.print("请选择：");
        while (true) {
            String input = scanner.next();
            if (input.equals("1")) {
                showAllList(bills, scanner);
            }
            if (input.equals("2")) {
                addBillInfo(scanner);
            }
            if (input.equals("3")) {
                deleteInfo(scanner);
            }
            if (input.equals("4")) {
                queryInfo(scanner);
            }
        }
    }

    /**
     * 查询记账信息
     *
     * @param scanner
     */
    private static void queryInfo(Scanner scanner) {
        showUse();
        List<Bill> queryList = new ArrayList<>();
        String n = scanner.next();
        String target = uses[Integer.parseInt(n)];
        for (Bill bill : bills) {
            if (target.contains(bill.getUse())) {
                queryList.add(bill);
            }
        }
        showAllList(queryList, scanner);
    }

    /**
     * 删除记账信息
     *
     * @param scanner
     */
    private static void deleteInfo(Scanner scanner) {
        System.out.print("请输入需要删除的编号：");
        List<Bill> newBillList = new ArrayList<>();
        int i = 0;
        String next = scanner.next();
        for (Bill bill : bills) {
            if (bill.getId().equals(next)) {
                i++;
                continue;
            }
            newBillList.add(bill);
        }
        if (i == 0) {
            System.err.println("没有需要删除的数据！");
        } else {
            System.err.println("删除成功！");
        }
        bills = newBillList;
        handleSystem(scanner);
    }

    /**
     * 添加记账信息
     *
     * @param scanner
     */
    private static void addBillInfo(Scanner scanner) {
        System.out.println("请输入费用:");
        String cost = scanner.next();
        System.out.println("请输入日期：");
        String date = scanner.next();
        showUse();
        String usr = scanner.next();
        Bill bill = new Bill();
        count++;
        bill.setId(String.valueOf(count));
        bill.setCost(cost);
        bill.setDate(date);
        bill.setUse(uses[Integer.parseInt(usr)]);
        bills.add(bill);
        System.out.println("===================================================================================");
        System.out.println(bill.toString());
        System.out.println("===================================================================================");
        System.out.println();
        handleSystem(scanner);
    }

    /**
     * 操作返回菜单还是退出系统
     *
     * @param scanner
     */
    public static void handleSystem(Scanner scanner) {

        System.out.println();
        System.out.println();
        System.out.println("请选择：");
        System.out.println("1： 返回菜单");
        System.out.println("2： 退出系统");
        System.out.print("请输入：");
        if (scanner.next().equals("1")) {
            menu(scanner);
        }
        if (scanner.next().equals("2")) {
            scanner.close();
            System.exit(0);
        }
    }

    /**
     * 输出记账信息
     *
     * @param list
     * @param scanner
     */
    private static void showAllList(List<Bill> list, Scanner scanner) {
        System.out.println("编号\t\t\t\t\t\t费用\t\t\t\t\t\t日期\t\t\t\t\t\t用途");
        System.out.println("===================================================================================");
        for (Bill b : list) {
            System.out.println(b.toString());
        }
        handleSystem(scanner);
    }

    /**
     * 显示用途
     */
    private static void showUse() {
        System.out.println("请选择用途：");
        for (int i = 0, j = uses.length; i < j; i++) {
            System.err.println(i + ": " + uses[i]);
        }
        try {
            //线程睡眠100ms 阻止同步输出
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.print("请输入：");
    }

}

/**
 * 记账对象
 */
class Bill {
    /**
     * 编号
     */
    private String id;
    /**
     * 费用
     */
    private String cost;
    /**
     * 日期
     */
    private String date;
    /**
     * 用途
     */
    private String use;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    @Override
    public String toString() {
        return id + "\t\t\t\t\t\t" + cost + "\t\t\t\t\t\t" + date + "\t\t\t\t" + use;
    }
}
