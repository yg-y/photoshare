package com.photoshare.dynamic;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/23 11:52
 * @description
 */
@Component
public class IDataSource {
    @Resource
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Resource
    private InitDataSource initDataSource;

    public boolean push(String code) {
        //切到默认数据源
        DataSourceContextHolder.removeDataSource();
        //找到所有的配置
        List<DatabaseList> databaseListList = initDataSource.databaseLists;

        if (!CollectionUtils.isEmpty(databaseListList)) {
            for (DatabaseList d : databaseListList) {
                if (d.getCode().equals(code)) {
                    //判断连接是否存在，不存在就创建
                    dynamicRoutingDataSource.checkCreateDataSource(d);
                    //切换数据源
                    DataSourceContextHolder.setDataSource(d.getCode());
                    return true;
                }
            }
        }
        return false;
    }

    public void pop() {
        dynamicRoutingDataSource.determineCurrentLookupKey();
    }
}
