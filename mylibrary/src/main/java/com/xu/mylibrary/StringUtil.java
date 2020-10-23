package com.xu.mylibrary;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 有关字符串处理的工具类。
 */

public class StringUtil {

    /**
     * string判空函数
     * <p>
     * 测试结果:
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = true
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     */

    public static boolean isEmpty(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据,来截取字符串
     *
     * @param string
     * @return
     */
    public static String[] split(String string) {
        String[] array = string.split("-");
        return array;
    }

    /**
     * 验证手机号是否非法
     *
     * @param phone
     * @return
     */
    public static boolean checkPhone(String phone) {
        Pattern pattern = Pattern.compile("^(/+8[56])?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
