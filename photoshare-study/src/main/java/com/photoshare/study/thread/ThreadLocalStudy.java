package com.photoshare.study.thread;

/**
 * @author young
 * @version 1.0
 * @date 2020/6/23 10:56 上午
 * @description 这个类提供了线程局部变量。 这些变量从它们的正常对应物，每个访问一个（通过其螺纹不同get或set方法）具有其自己的，独立地进行初始化的变量的副本。 ThreadLocal情况下，通常是那些希望联系邦与线程（例如，用户ID或事务ID）在类私有静态字段。
 * 例如，类下面生成本地给每个线程的唯一标识符。 线程的ID被分配在第一次调用ThreadId.get()并在后续调用不变。
 * import java.util.concurrent.atomic.AtomicInteger;
 * <p>
 * public class ThreadId {
 * // Atomic integer containing the next thread ID to be assigned
 * private static final AtomicInteger nextId = new AtomicInteger(0);
 * <p>
 * // Thread local variable containing each thread's ID
 * private static final ThreadLocal<Integer> threadId =
 * new ThreadLocal<Integer>() {
 * @Override protected Integer initialValue() {
 * return nextId.getAndIncrement();
 * }
 * };
 * <p>
 * // Returns the current thread's unique ID, assigning it if necessary
 * public static int get() {
 * return threadId.get();
 * }
 * }
 * <p>
 * 每个线程都保持对其线程局部变量副本的隐式引用，只要线程是活动的并且ThreadLocal实例访问; 一个线程消失之后，所有的线程局部实例的副本都会被垃圾回收（除非存在对这些副本的其他引用）。
 */
public class ThreadLocalStudy {

    //线程局部变量，线程隔离
    public static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                local.set("thread 1 set data");
                System.err.println("run is thread 1 set data");
                System.err.println("thread 1 get() _ " + local.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                local.set("thread 2 set data");
                System.err.println("run is thread 2 set data");
                System.err.println("thread 2 get() _ " + local.get());
            }
        }).start();

        while (true) {
            Thread.sleep(1000);
            System.err.println("master thread get() _ " + local.get());
        }
    }
}
