package com.photoshare.study.basicknowledge;

/**
 * 类加载顺序及实例化
 * <p>
 * 1.静态变量 从上到下一直加载
 * 2.静态代码
 */
public class T implements Cloneable {
    public static int k = 0;
    public static int i = 1;
    public static int n = 99;
    public static T t1 = new T("t1");
//    public static T t2 = new T("t2");

//
//    public int j = print("j");

    static {
        print("静态块");
    }

    {
        print("构造块");
    }


    public T(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "   n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {

    }
}
