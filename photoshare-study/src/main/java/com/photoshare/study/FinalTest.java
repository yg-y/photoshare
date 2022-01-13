package com.photoshare.study;

import okhttp3.*;

import java.io.IOException;

/**
 * final修饰在方法参数上，该参数值不能改变，否则编译报错
 */
public class FinalTest extends absTest {
    public static void main(String[] args) throws IOException {
        FinalTest finalTest = new FinalTest();
        System.err.println(finalTest.getInfo("zhangsan"));
        String name = "lisi";
        System.err.println(finalTest.getInfo(name));

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "order_number=205-8763783-5645942");
        Request request = new Request.Builder()
                .url("https://yks.lingxing.com/sc/routing/order/Order/getOrderDetail")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "bearer 3b5bgc9zl0bMHoS5+XI7Fsi/2T+2q1L5y/g3L6ZgfIJEx7exLA18FlnYIHtnAKUNyRwKZGAdlbFpH3kgNoL8OII+02GH/aCWVfwD1J8sMyg")
                .build();

        Response response = client.newCall(request).execute();

        System.err.println(response.body().string());
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

