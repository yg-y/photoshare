package com.young.system;

import com.sun.management.OperatingSystemMXBean;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSFileStore;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.RuntimeMXBean;
import java.net.Inet4Address;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * 系统监控
 *
 * @author young
 */
public class SystemMonitor {
    public static void main(String[] args) {
        SystemMonitor systemMonitor = new SystemMonitor();
        systemMonitor.init();
    }

    public void init() {
        try {

            SystemInfo systemInfo = new SystemInfo();

            OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            // 椎内存使用情况
            MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();

            // 非堆内存使用情况
            MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();

            // 初始的总内存
            long initTotalMemorySize = memoryUsage.getInit();
            // 最大可用内存
            long maxMemorySize = memoryUsage.getMax();
            // 已使用的内存
            long usedMemorySize = memoryUsage.getUsed();

            // 非堆初始的总内存
            long nonHeapMemoryUsageInit = nonHeapMemoryUsage.getInit();
            // 非堆最大可用内存
            long nonHeapMemoryUsageMax = nonHeapMemoryUsage.getMax();
            // 非堆已使用的内存
            long nonHeapMemoryUsageUsed = nonHeapMemoryUsage.getUsed();


            // 获取 java 启动参数
            RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
            List<String> startParam = bean.getInputArguments();

            // 操作系统
            String osName = System.getProperty("os.name");
            // 系统架构
            String osArch = System.getProperty("os.arch");
            // 系统 IP
            String ip = Inet4Address.getLocalHost().getHostAddress();
            // 总的物理内存
            String totalMemorySize = new DecimalFormat("#.##").format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
            // 剩余的物理内存
            String freePhysicalMemorySize = new DecimalFormat("#.##").format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
            // 已使用的物理内存
            String usedMemory = new DecimalFormat("#.##").format((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024) + "G";
            // 获得线程总数
            ThreadGroup parentThread;
            for (parentThread = Thread.currentThread().getThreadGroup(); parentThread.getParent() != null; parentThread = parentThread.getParent()) {

            }

            int totalThread = parentThread.activeCount();

            System.err.println("操作系统:" + osName);
            System.err.println("系统架构:" + osArch);
            System.err.println("操作系统IP:" + ip);
            System.err.println("程序启动时间:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ManagementFactory.getRuntimeMXBean().getStartTime())));
            System.err.println("cpu核数:" + Runtime.getRuntime().availableProcessors());
            printlnCpuInfo(systemInfo);
            getDiskInfo(systemInfo);
            System.err.println("JDK 名称:" + System.getProperty("java.vm.name"));
            System.err.println("JAVA_HOME:" + System.getProperty("java.home"));
            System.err.println("JAVA_VERSION:" + System.getProperty("java.version"));
            System.err.println("JAVA 启动参数:" + startParam.toString());
            System.err.println("USER_HOME:" + System.getProperty("user.home"));
            System.err.println("USER_NAME:" + System.getProperty("user.name"));
            System.err.println("初始的总内存(JVM):" + new DecimalFormat("#.#").format(initTotalMemorySize * 1.0 / 1024 / 1024) + "M");
            System.err.println("最大可用内存(JVM):" + new DecimalFormat("#.#").format(maxMemorySize * 1.0 / 1024 / 1024) + "M");
            System.err.println("已使用的内存(JVM):" + new DecimalFormat("#.#").format(usedMemorySize * 1.0 / 1024 / 1024) + "M");
            System.err.println("非堆初始的总内存(JVM):" + new DecimalFormat("#.#").format(nonHeapMemoryUsageInit * 1.0 / 1024 / 1024) + "M");
            System.err.println("非堆最大可用内存(JVM):" + new DecimalFormat("#.#").format(nonHeapMemoryUsageMax * 1.0 / 1024 / 1024) + "M");
            System.err.println("非堆已使用的内存(JVM):" + new DecimalFormat("#.#").format(nonHeapMemoryUsageUsed * 1.0 / 1024 / 1024) + "M");
            System.err.println("总的物理内存:" + totalMemorySize);
            System.err.println("总的物理内存:" + new DecimalFormat("#.##").format(systemInfo.getHardware().getMemory().getTotal() * 1.0 / 1024 / 1024 / 1024) + "M");
            System.err.println("剩余的物理内存:" + freePhysicalMemorySize);
            System.err.println("剩余的物理内存:" + new DecimalFormat("#.##").format(systemInfo.getHardware().getMemory().getAvailable() * 1.0 / 1024 / 1024 / 1024) + "M");
            System.err.println("已使用的物理内存:" + usedMemory);
            System.err.println("已使用的物理内存:" + new DecimalFormat("#.##").format((systemInfo.getHardware().getMemory().getTotal() - systemInfo.getHardware().getMemory().getAvailable()) * 1.0 / 1024 / 1024 / 1024) + "M");
            System.err.println("总线程数:" + totalThread);
            System.err.println("===========================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印 CPU 信息
     *
     * @param systemInfo
     */
    private void printlnCpuInfo(SystemInfo systemInfo) throws InterruptedException {
        CentralProcessor processor = systemInfo.getHardware().getProcessor();
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        // 睡眠1s
        TimeUnit.SECONDS.sleep(1);
        long[] ticks = processor.getSystemCpuLoadTicks();
        long nice = ticks[CentralProcessor.TickType.NICE.getIndex()] - prevTicks[CentralProcessor.TickType.NICE.getIndex()];
        long irq = ticks[CentralProcessor.TickType.IRQ.getIndex()] - prevTicks[CentralProcessor.TickType.IRQ.getIndex()];
        long softirq = ticks[CentralProcessor.TickType.SOFTIRQ.getIndex()] - prevTicks[CentralProcessor.TickType.SOFTIRQ.getIndex()];
        long steal = ticks[CentralProcessor.TickType.STEAL.getIndex()] - prevTicks[CentralProcessor.TickType.STEAL.getIndex()];
        long cSys = ticks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
        long user = ticks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
        long iowait = ticks[CentralProcessor.TickType.IOWAIT.getIndex()] - prevTicks[CentralProcessor.TickType.IOWAIT.getIndex()];
        long idle = ticks[CentralProcessor.TickType.IDLE.getIndex()] - prevTicks[CentralProcessor.TickType.IDLE.getIndex()];
        long totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        System.err.println("cpu核数:" + processor.getLogicalProcessorCount());
        System.err.println("cpu核心频率:" + new DecimalFormat("#.##GHz").format(processor.getProcessorIdentifier().getVendorFreq() * 1.0 / (1000 * 1000 * 1000)));
        System.err.println("cpu系统使用率:" + new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
        System.err.println("cpu用户使用率:" + new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
        System.err.println("cpu当前等待率:" + new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
        System.err.println("cpu当前空闲率:" + new DecimalFormat("#.##%").format(idle * 1.0 / totalCpu));

    }


    /**
     * 获取磁盘信息
     */
    public void getDiskInfo(SystemInfo systemInfo) {
        double unit = 1024 * 1024 * 1024;

        List<OSFileStore> fileStores = systemInfo.getOperatingSystem().getFileSystem().getFileStores();
        for (OSFileStore fileStore : fileStores) {
            System.err.println("================磁盘信息================");
            System.err.println("磁盘名称：" + fileStore.getName());
            System.err.println("磁盘格式：" + fileStore.getType().toUpperCase(Locale.ROOT));
            System.err.println("磁盘路径：" + fileStore.getMount());
            double totalSpace = fileStore.getTotalSpace();
            System.err.println("磁盘总空间：" + new DecimalFormat("#.##").format(totalSpace / unit) + "G");
            double usableSpace = fileStore.getUsableSpace();
            System.err.println("磁盘可用空间：" + new DecimalFormat("#.##").format(usableSpace / unit) + "G");
            System.err.println("磁盘的已用大小：" + new DecimalFormat("#.##").format((totalSpace - usableSpace) / unit) + "G");
            System.err.println("已用百分比：" + new DecimalFormat("#.##").format(((((totalSpace - usableSpace) / unit) / (totalSpace / unit)) * 100)) + "%");
            System.err.println("=======================================");
        }

    }

}