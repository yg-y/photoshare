package com.photoshare.study.thread.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author young
 * @version 1.0
 * @date 2020/11/26 下午10:43
 * @description CAS 非阻塞式原子操作
 */
public class Atomic {

    private static AtomicLong atomicLong = new AtomicLong();

    /**
     * 使用 LongAdder 解决 AtomicLong 出现到性能问题
     * LongAdder 在内存中维护多个原子变量，多线程竞争各自获取不同到原子变量，返回是 累加到 base 返回。
     */
    private static LongAdder longAdder = new LongAdder();

    private static Integer[] arrayOne = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayTwo = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    /**
     * 该实现会存在性能问题
     * 高并发时大量线程会同时竞争一个原子变量，但是CAS只有一个线程会操作成功，所以其他线程竞争失败会不断无限循环自旋操作，浪费大量性能
     * 可以通过 LongAdder 解决
     * 自旋锁：没有获取到资源时，重复获取
     * return unsafe.getAndAddLong(this, valueOffset, 1L) + 1L;
     * <p>
     * getAndAddLong() 实现 ⬇️
     * <p>
     * public final long getAndAddLong(Object var1, long var2, long var4) {
     * long var6;
     * do {
     * var6 = this.getLongVolatile(var1, var2);
     * } while(!this.compareAndSwapLong(var1, var2, var6, var6 + var4));
     * <p>
     * return var6;
     * }
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayOne.length;
                for (int i = 0; i < size; ++i) {
                    if (arrayOne[i] == 0) {
                        // incrementAndGet : Atomically increments by one the current value.
                        // 此方法已原子方式加一
                        atomicLong.incrementAndGet();
//                        longAdder.add(1L);
                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayTwo.length;
                for (int i = 0; i < size; ++i) {
                    if (arrayTwo[i] == 0) {
                        atomicLong.incrementAndGet();
//                        longAdder.add(1L);
                    }
                }
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadOne.join();

        System.err.println("atomicLong count 0 : " + atomicLong.get());
        System.err.println("longAdder count 0 : " + longAdder.longValue());
    }
}

