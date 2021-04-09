package com.young.photoshare.annotation;

import java.lang.annotation.*;

/**
 * @author young
 * @version 1.0
 * @date 2021/4/9 10:44 上午
 * @description
 */
@Documented // 注解包含在javadoc中
@Inherited // 注解可以被继承
@Target({ElementType.FIELD, ElementType.METHOD}) // 字段、枚举的常量 方法
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
public @interface Init {
    public String value() default "";
}
