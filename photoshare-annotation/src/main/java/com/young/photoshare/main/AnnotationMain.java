package com.young.photoshare.main;

import com.young.photoshare.entity.UserEntity;
import com.young.photoshare.factory.UserFactory;

/**
 * @author young
 * @version 1.0
 * @date 2021/4/9 10:49 上午
 * @description
 */
public class AnnotationMain {

    public static void main(String[] args) {
        UserEntity userEntity = UserFactory.create();

        System.err.println(userEntity.getId());
        System.err.println(userEntity.getName());
        System.err.println(userEntity.getEmail());
    }
}
