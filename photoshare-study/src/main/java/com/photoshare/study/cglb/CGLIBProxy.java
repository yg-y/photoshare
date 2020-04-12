package com.photoshare.study.cglb;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBProxy implements MethodInterceptor {

    public <T> T getInstance(Class classz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(classz);
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.err.println("login begin");
        Object object = methodProxy.invokeSuper(o, objects);
        System.err.println("login success");
        return object;
    }
}
