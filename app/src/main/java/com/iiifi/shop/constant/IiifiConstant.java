package com.iiifi.shop.constant;

/**
 * Created by dmm on 2017/3/29.
 */

public class IiifiConstant {
    /**
     * 0.否
     */
    public static final String FALSE="0";
    /**
     * 1.是
     */
    public static final String TRUE="1";


    //手机号码正则表达式
    public static final String phoneRegex = "^1(3|4|5|7|8)\\d{9}";

    //密码的正则表达式
    public static final String passwordRegex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";

    //验证码正则表达式
    public static final String smsCodeRegex = "^\\d{4}";

}
