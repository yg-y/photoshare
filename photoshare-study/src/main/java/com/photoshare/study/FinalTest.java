package com.photoshare.study;

import okhttp3.*;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * final修饰在方法参数上，该参数值不能改变，否则编译报错
 */
public class FinalTest extends absTest {
    public static void main(String[] args) throws IOException {
        int a = 1;
        int b = 0;

        System.err.println(a << 2);

        Map map = new HashMap<String, String>();
        map.put("", "");
        List<String> aa = new ArrayList<>();
        aa.add("");
        Map<String, String> map1 = new ConcurrentHashMap<>();
        map1.put("", "");
        map1.get("");
        LinkedList<Object> linkedList = new LinkedList<>();
        linkedList.add("");
        linkedList.get(1);
        linkedList.add(1, "");

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

