package com.photoshare.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author young
 * @version 1.0
 * @date 2022/8/23 11:58
 * @description
 */
@Configuration
public class InitDataSource {

    @Autowired
    private DynamicRoutingDataSource dynamicRoutingDataSource;

    @Value("${spring.datasource.dynamic.datasource.ykscrm.url}")
    private String ykscrmUrl;
    @Value("${spring.datasource.dynamic.datasource.ykscrm.username}")
    private String ykscrmUser;
    @Value("${spring.datasource.dynamic.datasource.ykscrm.password}")
    private String ykscrmPassword;
    @Value("${spring.datasource.dynamic.datasource.task.url}")
    private String taskUrl;
    @Value("${spring.datasource.dynamic.datasource.task.username}")
    private String taskUser;
    @Value("${spring.datasource.dynamic.datasource.task.password}")
    private String taskPassword;
    @Value("${spring.datasource.dynamic.datasource.amazon.url}")
    private String amazonUrl;
    @Value("${spring.datasource.dynamic.datasource.amazon.username}")
    private String amazonUser;
    @Value("${spring.datasource.dynamic.datasource.amazon.password}")
    private String amazonPassword;
    @Value("${spring.datasource.dynamic.datasource.ebay.url}")
    private String ebayUrl;
    @Value("${spring.datasource.dynamic.datasource.ebay.username}")
    private String ebayUser;
    @Value("${spring.datasource.dynamic.datasource.ebay.password}")
    private String ebayPassword;

    List<DatabaseList> databaseLists = new ArrayList<>();

    /**
     * todo 最好将数据库连接放数据库，从数据库中读取配置
     */
    @Bean
    public void init() {
        DatabaseList amazon = new DatabaseList();
        amazon.setCode("YA");
        amazon.setUrl(amazonUrl);
        amazon.setUser(amazonUser);
        amazon.setPassword(amazonPassword);
        databaseLists.add(amazon);

        DatabaseList ebay = new DatabaseList();
        ebay.setCode("EB");
        ebay.setUrl(ebayUrl);
        ebay.setUser(ebayUser);
        ebay.setPassword(ebayPassword);
        databaseLists.add(ebay);

        DatabaseList ykscrm = new DatabaseList();
        ykscrm.setCode("ykscrm");
        ykscrm.setUrl(ykscrmUrl);
        ykscrm.setUser(ykscrmUser);
        ykscrm.setPassword(ykscrmPassword);
        databaseLists.add(ykscrm);

        DatabaseList task = new DatabaseList();
        task.setCode("task");
        task.setUrl(taskUrl);
        task.setUser(taskUser);
        task.setPassword(taskPassword);
        databaseLists.add(task);

        for (DatabaseList databaseList : databaseLists) {
            dynamicRoutingDataSource.createDataSource(databaseList);
        }

    }
}
