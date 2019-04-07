package com.photoshare.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用户代理类
 */
public class UserDynamicProxy implements InvocationHandler {

    // 在线人数
    public static int count = 0;
    // 委托对象
    private Object target;

    public <T> T getProxyInstance(Object target) {
        this.target = target;
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] classInterface = target.getClass().getInterfaces();
        return (T) Proxy.newProxyInstance(classLoader, classInterface, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object r = null;
        // 执行之前
        r = method.invoke(target, args);
        // 判断如果是登录方法
        if ("login".equals(method.getName())) {
            if ((boolean) r == true) {
                // 当前在线人数+1
                count += 1;
            }
        }
        // 判断如果是退出方法
        else if ("logout".equals(method.getName())) {
            // 当前在线人数-1
            count -= 1;
        }
        showCount(); // 输出在线人数
        // 执行之后
        return r;
    }

    /**
     * 输出在线人数
     */
    public void showCount() {
        System.out.println("当前在线人数：" + count + " 人.");
    }
}
