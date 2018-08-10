package com.weijun.helpcircle.utils;

import com.blankj.utilcode.util.StringUtils;

import java.util.logging.Level;

public class PhoneUtils {

    /**
     * 把输入的手机号按 183 0594 3153 这种格式做格式化
     *
     * @param phone 手机号
     */
    public static String sort344(String phone) {

        String newPhone = "";
        //去掉所有空格
        phone = phone.replaceAll("\\s*", "");
        int length = phone.length();
        StringBuilder sb = new StringBuilder(phone);
        if (length > 7) {
            sb.insert(7, " ");
            sb.insert(3, " ");
            newPhone = sb.toString();
        } else if (length > 3) {
            sb.insert(3, " ");
            newPhone = sb.toString();
        }

        return newPhone;
    }

    public static String formatPass(String phone) {
        String newPhone;
        phone = phone.trim();
        int length = phone.length();
        StringBuilder sb = new StringBuilder(phone);
        if (length >= 3) {
            sb.replace(3, 7, "****");
        }

        return sb.toString();
    }
}
