package com.photoshare.study.exception;

/**
 * 研究异常
 */
public class ExceptionStudy {

    public static void main(String[] args) {
        System.err.println(resultStr());
    }

    /**
     * 最终会执行finally，所以返回的是字符串 2
     *
     * @return
     */
    public static String resultStr() {
        try {
            return "1";
        } catch (Exception e) {
            return "Exception";
        } finally {
            return "2";
        }
    }
}
