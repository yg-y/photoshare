package com.photoshare.study;

/**
 * final修饰在方法参数上，该参数值不能改变，否则编译报错
 */
public class FinalTest extends absTest {
    public static void main(String[] args) {
        FinalTest finalTest = new FinalTest();
        System.err.println(finalTest.getInfo("zhangsan"));
        String name = "lisi";
        System.err.println(finalTest.getInfo(name));
    }

    String getInfo(final String name) {
        // 报错
        //        name = "yangguang";
        return name;
    }


    /**
     * 抽象类只能继承。不能实现
     * 继承抽象类 必须实现抽象方法
     *
     * @return
     */
    @Override
    public String test2() {
        return null;
    }
}

/**
 * 抽象类
 */
abstract class absTest {
    public String test() {
        return null;
    }

    public abstract String test2();
}
