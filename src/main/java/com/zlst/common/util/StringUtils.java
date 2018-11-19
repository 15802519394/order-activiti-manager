package com.zlst.common.util;

/**
 * 字符串工具类
 *
 * @auther 何凯
 * @create 2017/9/13 16:01
 */
public class StringUtils {

    public StringUtils() {
    }

    /**
     * 含空格去掉空格
     *
     * @param str
     * @return
     */
    public static String trimToEmpty(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * 变成空字符串
     *
     * @param str
     * @return
     */
    public static String toEmpty(String str) {
        return str == null ? "" : str;
    }

    /**
     * 为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 判断空格
     *
     * @param str
     * @return
     */
    public static boolean isNotEmptyTrim(String str) {
        if (isNotEmpty(str)) {
            if (isNotEmpty(str.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 指示指定的 String 对象是否为空引用或空字符串。
     *
     * @param s 一个 String 引用。
     * @return 如果 s 是空引用或空字符串（""），则为 true；否则为 false。
     */
    public static boolean isNullOrEmpty(String s) {
        if (s != null) {
            return (s.length() == 0);
        }
        return true;
    }

    /**
     * 指示指定的 String 对象是否为空引用、空字符串或者只包含空白字符的字符串。
     *
     * @param s 一个 String。
     * @return 如果 s 是空引用、空字符串（""）或者只包含空白字符的字符串， 则为 true；否则为 false。
     */
    public static boolean isNullOrBlank(String s) {
        if ((s == null) || (s.length() == 0) || (s.trim().length() == 0)) {
            return true;
        }
        return false;
    }

    /**
     * 判断两个可能为null的字符串是否相同
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean compareString(String a, String b) {
        if (null == a && b != null) {
            if ("".equals(b)) {
                return true;
            } else {
                return false;
            }
        } else if (null == b && a != null) {
            if ("".equals(a)) {
                return true;
            } else {
                return false;
            }
        } else if (null != b && a != null) {
            return b.equals(a);
        } else {
            return true;
        }
    }

    /*
     * Java文件操作 获取不带扩展名的文件名
     *
     *  Created on: 2018-9-30
     *  Author: jinxin
     */
    public static String getFileNameNoEx(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length()))) {
                return filename.substring(0, dot);
            }
        }
        return filename;
    }
}
