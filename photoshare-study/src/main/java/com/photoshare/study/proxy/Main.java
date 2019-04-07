package com.photoshare.study.proxy;

/**
 * 动态代理学习
 * <p>
 * 主程序入口
 */
public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();

        UserDynamicProxy userDynamicProxy = new UserDynamicProxy();

        UserService userDynamicProxyProxyInstance = userDynamicProxy.getProxyInstance(userService);

        userDynamicProxyProxyInstance.login("liyang", "6666");
        userDynamicProxyProxyInstance.login("liyang", "6666");
        userDynamicProxyProxyInstance.login("liyang", "6666");
        userDynamicProxyProxyInstance.login("liyang", "6666");
        userDynamicProxyProxyInstance.login("liyang", "6666");
        userDynamicProxyProxyInstance.login("liyang", "6666");

        userDynamicProxyProxyInstance.logout("liyang");
        userDynamicProxyProxyInstance.logout("liyang");
        userDynamicProxyProxyInstance.logout("liyang");
        userDynamicProxyProxyInstance.logout("liyang");
    }
}
