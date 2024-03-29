package com.photoshare.dynamic;

import lombok.extern.slf4j.Slf4j;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/23 11:44
 * @description
 */
@Slf4j
public class DataSourceContextHolder {

    private static final ThreadLocal<String> DATA_SOURCE = new ThreadLocal<>();

    /**
     * 切换数据源
     */
    public static void setDataSource(String datasourceId) {
        DATA_SOURCE.set(datasourceId);
        log.info("已切换到数据源:{}", datasourceId);
    }

    public static String getDataSource() {
        return DATA_SOURCE.get();
    }

    /**
     * 删除数据源
     */
    public static void removeDataSource() {
        DATA_SOURCE.remove();
        log.info("已切换到默认主数据源");
    }
}
