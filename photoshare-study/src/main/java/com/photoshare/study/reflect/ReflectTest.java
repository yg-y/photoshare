package com.photoshare.study.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 */
public class ReflectTest {

    public static void main(String[] args) {
        reflectMethod();
//        reflectFiled();
    }

    /**
     * 反射实例化的三种方式
     * 以及调用实例执行方法
     * getMethod()  获取public方法
     * getDeclaredMethods() 获取所有方法
     */
    static void reflectMethod() {
        try {
            Car car;
            //根据包路径获取反射对象
            Class carClass = Class.forName("com.photoshare.study.reflect.Car");

            //通过.class
//          Class carClass2 = Car.class;

            //car.getClass;
//          Class carClass3 = car.getClass();

            //获取public修饰的方法
            Method method = carClass.getMethod("print", String.class);

            //获取所有的方法
            Method[] methods = carClass.getDeclaredMethods();
            for (Method m : methods) {
                System.err.println(m.getName());
            }

            //通过newInstance创建实例
            car = (Car) carClass.newInstance();
            String result = car.print("2018-19-1");
            System.err.println("newInstance run : " + result);

//        通过method.invoke执行方法
            String resultInMethod = (String) method.invoke(car, "2019-12-12");
            System.err.println("method run : " + resultInMethod);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 反射获取属性
     * getFields()  获取public 修饰符的字段
     * getDeclaredFields()  获取全部字段
     */
    static void reflectFiled() {
        Class clazz = Car.class;

        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = field.getName();
            System.err.println("public field : " + fieldName);
        }
    }
}
