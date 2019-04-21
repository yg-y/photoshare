package com.young.photoshare.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 公共返回类
 */
@Data
public class R {

    private String sate;
    private Object object;
    private static final String SUCCESS_STATE = "200";
    private static final String ERROR_STATE = "200";

    public R(String sate, Object object) {
        this.setSate(sate);
        this.setObject(object);
    }

    public static R success() {
        return new R(SUCCESS_STATE, null);
    }

    public static R success(Object object) {
        return new R(SUCCESS_STATE, object);
    }

    public static R success(String state, Object object) {
        return new R(state, object);
    }

    public static R error(String state, Object object) {
        return new R(state, object);
    }

    public static R error(Object object) {
        return new R(ERROR_STATE, object);
    }

    public static R error() {
        return new R(ERROR_STATE, null);
    }
}
