package com.young.photoshare.utils;

import lombok.Data;

/**
 * 公共返回类
 */
@Data
public class R<T> {

    private Integer code;
    private String msg;
    private T data;
    private static final Integer SUCCESS_STATE = 20000;
    private static final Integer ERROR_STATE = 50000;

    public R(Integer code, T data) {
        this.setCode(code);
        this.setData(data);
    }

    public R(String msg) {
        this.setCode(ERROR_STATE);
        this.setMsg(msg);
    }

    public static R success() {
        return new R(SUCCESS_STATE, null);
    }

    public static R success(Object object) {
        return new R(SUCCESS_STATE, object);
    }

    public static R success(Integer code, Object object) {
        return new R(code, object);
    }

    public static R error(Integer code, Object object) {
        return new R(code, object);
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
