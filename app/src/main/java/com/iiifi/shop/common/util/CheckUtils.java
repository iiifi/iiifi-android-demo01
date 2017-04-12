package com.iiifi.shop.common.util;

import android.text.TextUtils;

import com.iiifi.shop.constant.IiifiConstant;

/**
 * Created by dmm on 2017/4/12.
 */

public class CheckUtils {

    /**
     * 校验手机号
     * @param phone
     * @return  内容符合手机号要求返回true
     */
    public static boolean checkPhone(String phone){
        return (!TextUtils.isEmpty(phone))&&phone.matches(IiifiConstant.phoneRegex);
    }

    /**
     * 校验密码
     * @param password
     * @return  内容符合密码要求返回true
     */
    public static boolean checkPassword(String password){
        return (!TextUtils.isEmpty(password))&&password.matches(IiifiConstant.passwordRegex);
    }

    /**
     * 校验验证码
     * @param smsCode
     * @return  内容符合验证码要求返回true
     */
    public static boolean checkSmsCode(String smsCode){
        return (!TextUtils.isEmpty(smsCode))&&smsCode.matches(IiifiConstant.smsCodeRegex);
    }
}
