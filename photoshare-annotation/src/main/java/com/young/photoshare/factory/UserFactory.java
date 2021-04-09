package com.young.photoshare.factory;

import com.young.photoshare.annotation.Init;
import com.young.photoshare.entity.UserEntity;

import java.lang.reflect.Method;

/**
 * @author young
 * @version 1.0
 * @date 2021/4/9 10:51 上午
 * @description
 */
public class UserFactory {
    public static UserEntity create() {
        UserEntity user = new UserEntity();

        // 获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = UserEntity.class.getMethods();

        try {
            for (Method method : methods) {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (method.isAnnotationPresent(Init.class)) {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return user;
    }
}
