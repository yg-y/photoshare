package com.photoshare.study.jvm;

public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC obj1 = new ReferenceCountingGC();
        ReferenceCountingGC obj2 = new ReferenceCountingGC();

        obj1.instance = obj2;
        obj2.instance = obj1;

        obj1 = null;
        obj2 = null;

        //HotSpot 没有因为对象的互相引用而导致对象不GC 所以HotSpot JVM 不是单纯通过计数器来判断对象是否GC
        System.gc();

    }
}
