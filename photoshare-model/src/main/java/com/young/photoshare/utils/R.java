package com.young.photoshare.utils;

import lombok.Data;

/**
 * 公共返回类
 */
@Data
public class R<T> {

    private String sate;
    private String msg;
    private T data;
    private static final String SUCCESS_STATE = "200";
    private static final String ERROR_STATE = "500";

    public R(String sate, T data) {
        this.setSate(sate);
        this.setData(data);
    }

    public R(String msg) {
        this.setSate(ERROR_STATE);
        this.setMsg(msg);
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

    public static R error(String msg) {
        return new R(msg);
    }

    public static R error() {
        return new R(ERROR_STATE, null);
    }
}
