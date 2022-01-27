package com.photoshare.study.beetl;

import lombok.SneakyThrows;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

/**
 * @author young
 * @version 1.0
 * @date 2022/1/27 10:14 AM
 * @description
 */
public class BeetlTemplate {


    @SneakyThrows
    public static void main(String[] agrs) {
        //初始化代码
        StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        //获取模板
        Template t = gt.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        //渲染结果
        String str = t.render();
        System.out.println(str);
    }
}
