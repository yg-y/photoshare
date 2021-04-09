package com.young.photoshare.entity;

import com.young.photoshare.annotation.Init;

/**
 * @author young
 * @version 1.0
 * @date 2021/4/9 10:47 上午
 * @description
 */
public class UserEntity {

    private Integer id;

    private String name;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Init("young")
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    @Init("young.yg@foxmail.com")
    public void setEmail(String email) {
        this.email = email;
    }
}
