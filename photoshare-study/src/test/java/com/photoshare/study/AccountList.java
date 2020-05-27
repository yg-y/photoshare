package com.photoshare.study;

import java.time.LocalDateTime;
import java.util.*;

public class AccountList {

    //编号计数器
    static Integer count = 0;
    //创建财务记录
    static List<Bill> bills = new ArrayList<>();
    //创建用途分类
    static String[] uses = {"学习", "餐饮", "出行", "娱乐", "服饰", "旅游"};
    //创建预算记录
    static Map<String, Integer> budgetMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        menu(scanner);
    }

    /**
     * 菜单
     *
     * @param scanner
     */
    public static void menu(Scanner scanner) {
        System.out.println("====================欢迎使用记账清单系统====================");
        sleep(100);
        System.err.println("1：显示所有记录");
        System.err.println("2：添加记录");
        System.err.println("3：删除记录");
        System.err.println("4：按用途查询");
        System.err.println("5：查询开支(只能查询到月份，如：2020-02)");
        System.err.println("6：预算配置");
        System.err.println("7：显示所有预算配置");
        System.err.print("请选择：");
        String input = scanner.next();
        try {
            int i = Integer.parseInt(input);
            if (i > 7) {
                System.err.println("系统提示：请输入正确的选项");
                menu(scanner);
            }
        } catch (Exception e) {
            System.err.println("系统提示：请输入正确的选项");
            menu(scanner);
        }
        //根据输入的选项跳转对应的功能
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
        if (input.equals("5")) {
            queryCost(scanner);
        }
        if (input.equals("6")) {
            setBudget(scanner);
        }
        if (input.equals("7")) {
            showBudget(scanner);
        }
    }

    /**
     * 显示全部预算配置
     */
    public static void showBudget(Scanner scanner) {
        if (budgetMap.entrySet().isEmpty()) {
            System.err.println("系统提示：暂无预算配置!");
            handleSystem(scanner);
        }
        // 使用迭代器获取map中对应的key，通过key获取对应的value
        Iterator<Map.Entry<String, Integer>> iterator = budgetMap.entrySet().iterator();
        System.out.println("年月\t\t\t\t\t\t\t预算");
        System.out.println("==========================================================");
        while (iterator.hasNext()) {
            String key = iterator.next().getKey();
            System.out.println(key + "\t\t\t\t\t\t" + budgetMap.get(key));
        }
        handleSystem(scanner);
    }

    /**
     * 预算配置
     *
     * @param scanner
     */
    public static void setBudget(Scanner scanner) {
        String date;
        while (true) {
            System.out.println("请输入配置的年月(格式:2020-01)：");
            date = scanner.next() + "-01";
            if (checkDate(date, "2020-01")) {
                break;
            }
        }
        date = date.replace("-01", "");
        String cost;
        while (true) {
            System.out.println("请输入预算费用:");
            cost = scanner.next();
            if (checkNumber(cost)) {
                break;
            }
        }
        budgetMap.put(date, Integer.valueOf(cost));
        handleSystem(scanner);
    }

    /**
     * 查询开支
     *
     * @param scanner
     */
    public static void queryCost(Scanner scanner) {
        String date;
        while (true) {
            System.out.println("请输入查询的年月(格式:2020-01)：");
            // 为输入（输入的格式为 yyyy-mm ）的日期拼接为正确的日期校验格式 yyyy-mm-dd
            // 这样可以使用同一个日期校验方法
            date = scanner.next() + "-01";
            if (checkDate(date, "2020-01")) {
                break;
            }
        }
        // 校验通过后移除拼接的日期
        date = date.replace("-01", "");
        List<Bill> filterList = new ArrayList<>();
        // 循环判断符合当前日期的数据添加到新的集合中
        for (Bill bill : bills) {
            if (bill.getDate().contains(date)) {
                filterList.add(bill);
            }
        }
        // 集合大小小于零时，提示无数据，大于零才进行后续操作
        if (filterList.size() > 0) {
            showCostList(filterList, date, scanner);
        } else {
            System.err.println("系统提示：暂无数据!");
        }
        // 显示返回和退出系统操作
        handleSystem(scanner);
    }

    /**
     * 查询记账信息
     *
     * @param scanner
     */
    public static void queryInfo(Scanner scanner) {
        // 显示用途列表
        showUse();
        List<Bill> queryList = new ArrayList<>();
        String n = scanner.next();
        // 根据输入的编号找到对应的用途
        String target = uses[Integer.parseInt(n)];
        for (Bill bill : bills) {
            if (target.contains(bill.getUse())) {
                queryList.add(bill);
            }
        }
        // 调用封装好的显示方法显示数据
        showAllList(queryList, scanner);
    }

    /**
     * 删除记账信息
     *
     * @param scanner
     */
    public static void deleteInfo(Scanner scanner) {
        System.out.print("请输入需要删除的编号：");
        List<Bill> newBillList = new ArrayList<>();
        int i = 0;
        String next = scanner.next();
        for (Bill bill : bills) {
            // 根据编号找到对应的数据
            if (bill.getId().equals(next)) {
                i++;
                continue;
            }
            newBillList.add(bill);
        }
        if (i == 0) {
            System.err.println("系统提示：没有需要删除的数据!");
        } else {
            System.err.println("系统提示：删除成功!");
        }
        bills = newBillList;
        handleSystem(scanner);
    }

    /**
     * 添加记账信息
     *
     * @param scanner
     */
    public static void addBillInfo(Scanner scanner) {
        // 使用while 循环直到用户结果输入正确后才跳出循环
        String cost;
        while (true) {
            System.out.println("请输入费用:");
            cost = scanner.next();
            if (checkNumber(cost)) {
                break;
            }
        }
        String date;
        while (true) {
            System.out.println("请输入日期(格式:2020-01-01)：");
            date = scanner.next();
            if (checkDate(date, "2020-01-01")) {
                break;
            }
        }
        String usr;
        while (true) {
            showUse();
            usr = scanner.next();
            if (checkSelect(usr)) {
                break;
            }
        }

        Bill bill = new Bill();
        // 编号+1
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
        } else {
            System.err.println("系统提示：请输入正确的选项!");
            handleSystem(scanner);
        }
    }

    /**
     * 输出记账信息
     *
     * @param list
     * @param scanner
     */
    public static void showAllList(List<Bill> list, Scanner scanner) {
        System.out.println("编号\t\t\t\t\t\t费用\t\t\t\t\t\t日期\t\t\t\t\t\t用途");
        System.out.println("===================================================================================");
        for (Bill b : list) {
            System.out.println(b.toString());
        }
        handleSystem(scanner);
    }

    /**
     * 显示预算
     *
     * @param list
     * @param date
     * @param scanner
     */
    public static void showCostList(List<Bill> list, String date, Scanner scanner) {
        System.out.println("编号\t\t\t\t\t\t费用\t\t\t\t\t\t日期\t\t\t\t\t\t用途");
        System.out.println("===================================================================================");
        for (Bill b : list) {
            System.out.println(b.toString());
        }
        System.out.println();
        System.out.println("===================================================================================");
        Set<Map.Entry<String, Integer>> entries = budgetMap.entrySet();
        sleep(100);
        // 判断预算配置是否为空
        if (!entries.isEmpty()) {
            Double allCount = 0.0;

            // += 全部数据的费用
            for (Bill bill : list) {
                allCount += Double.valueOf(bill.getCost());
            }

            // 使用迭代器找到对应查询月份的预算配置
            Iterator<Map.Entry<String, Integer>> iteratorMonth = entries.iterator();
            System.err.print("当前月预算->");
            Double totalCost = 0.0;
            while (iteratorMonth.hasNext()) {
                String dateByKey = iteratorMonth.next().getKey();
                // 找到符合查询月份的预算配置
                if (dateByKey.equals(date)) {
                    Integer costByValue = budgetMap.get(dateByKey);
                    totalCost += Double.valueOf(costByValue);
                    System.err.println(dateByKey + " : " + costByValue);
                }
            }
            // 用全部预算减去记录中的预算得到剩余预算
            System.err.println("当月剩余预算：" + (totalCost - allCount));
        } else {
            System.err.println("系统提示：没有配置预算!");
        }
        sleep(100);
        handleSystem(scanner);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }

    /**
     * 显示用途
     */
    public static void showUse() {
        System.out.println("请选择用途：");
        for (int i = 0, j = uses.length; i < j; i++) {
            System.err.println(i + ": " + uses[i]);
        }
        sleep(100);
        System.out.print("请输入：");
    }

    /**
     * 费用校验
     *
     * @param account
     */
    public static boolean checkNumber(String account) {
        boolean target = true;
        try {
            // 转成  Double 类型数据，如果不能转则抛出异常 在异常中提示费用不正确
            double accountChange = Double.parseDouble(account);
            if (accountChange < 0) {
                System.err.println("系统提示：费用不能为负数!");
                target = false;
            }
        } catch (Exception e) {
            System.err.println("系统提示：请输入正确的金额!");
            target = false;
        }
        return target;
    }

    /**
     * 校验日期
     *
     * @param date
     */
    public static boolean checkDate(String date, String dateFormat) {
        boolean target = true;
        // 获取当前的年月日
        Integer dayYear = LocalDateTime.now().getYear();
        Integer dayMonth = LocalDateTime.now().getMonthValue();
        Integer dayNow = LocalDateTime.now().getDayOfMonth();

        // 根据 "-" 分隔日期成为数组
        String[] splitDates = date.split("-");
        // 如果日期数组大小不等于3 则代表不是 年月日 格式
        if (splitDates.length != 3) {
            target = false;
            System.err.println("系统提示: 日期输入格式不正确，正确格式为 " + dateFormat);
        }
        // 如果是年月日格式则获取对应年月日数据
        Integer inputYear = 0;
        Integer inputMonth = 0;
        Integer inputDay = 0;
        // 如果格式正确，但是内容不正确 如 2sa0-22-aa 则抛出异常 数据格式不正确
        try {
            inputYear = Integer.valueOf(splitDates[0]);
            inputMonth = Integer.valueOf(splitDates[1]);
            inputDay = Integer.valueOf(splitDates[2]);
        } catch (Exception e) {
            target = false;
            System.err.println("系统提示: 日期输入格式不正确，正确格式为 " + dateFormat);
        }

        // 校验日期不能输入未来时间
        if (dayYear < inputYear || (dayYear.equals(inputYear) && dayMonth < inputMonth)
                || (dayYear.equals(inputYear) && dayMonth.equals(inputMonth)) && dayNow < inputDay) {
            target = false;
            System.err.println("系统提示：请输入" + dayYear + "年" + dayMonth + "月份之后的日期!");
        }
        return target;
    }

    /**
     * 校验输入选项
     *
     * @param selected
     */
    public static boolean checkSelect(String selected) {
        Integer select = 0;
        boolean target = true;
        try {
            select = Integer.parseInt(selected);
        } catch (Exception e) {
            target = false;
            System.err.println("系统提示：请输入正确的选项!");
        }
        if (uses.length - 1 < select) {
            target = false;
            System.err.println("系统提示：没有该选项!");
        }
        return target;
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
