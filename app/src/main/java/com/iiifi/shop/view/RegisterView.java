package com.iiifi.shop.view;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.iiifi.shop.activity.LoginActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.activity.RegisterActivity;

/**
 * Created by dmm on 2017/3/25.
 */

public class RegisterView {

    private static boolean IS_SEE=false;

    private RegisterActivity registerActivity;
    /**
     * 登录名
     */
    private EditText etLoginName;
    private ImageView loginNameDel;

    /**
     * 验证码
     */
    private EditText etSmsCode;
    private ImageView smsCodeDel;
    private TextView sendCode;
    /**
     * 密码
     */
    private  EditText etPassword;
    private  ImageView passwordDel;
    private  ImageView see_password;

    /**
     * 注册
     */
    private TextView registerBtn;

    /**
     * 第三方登录
     */
    private ImageView ivQQ;

    private ImageView ivSina;

    private ImageView ivWeixin;

    /**
     * 登录
     */
    private TextView loginBtn;

    /**
     * 快速登录
     */
    private TextView speedLogin;

    //编译控件
    public static void build(RegisterActivity registerActivity){
        new RegisterView(registerActivity);
    }

    public  RegisterView(RegisterActivity registerActivity){
        this.registerActivity=registerActivity;
        initView(registerActivity);
        initEvent();
    }


    /**
     * 初始化控件
     * @param registerActivity
     */
    public  void initView(RegisterActivity registerActivity){
        //登录名
        etLoginName= (EditText) registerActivity.findViewById(R.id.et_login_name);
        loginNameDel= (ImageView) registerActivity.findViewById(R.id.login_name_del);
        //验证码
        etSmsCode = (EditText) registerActivity.findViewById(R.id.et_sms_code);
        smsCodeDel = (ImageView) registerActivity.findViewById(R.id.sms_code_del);
        sendCode = (TextView) registerActivity.findViewById(R.id.send_code);
        //密码
        etPassword = (EditText) registerActivity.findViewById(R.id.et_paswword);
        passwordDel = (ImageView) registerActivity.findViewById(R.id.password_del);
        see_password = (ImageView) registerActivity.findViewById(R.id.see_password);
        //第三方登录
        ivQQ = (ImageView) registerActivity.findViewById(R.id.iv_qq);
        ivSina = (ImageView) registerActivity.findViewById(R.id.iv_sina);
        ivWeixin = (ImageView) registerActivity.findViewById(R.id.iv_weixin);
        //快速登录
        speedLogin = (TextView) registerActivity.findViewById(R.id.speed_login);
        //登录
        loginBtn = (TextView) registerActivity.findViewById(R.id.login_btn);
    }

    /**
     * 绑定控件事件
     */
    public void initEvent(){
        //登录名输入框设置监听
        etLoginName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(etLoginName.getText())) {
                    loginNameDel.setVisibility(View.VISIBLE);

                } else {
                    loginNameDel.setVisibility(View.GONE);
                }

            }
        });
        //登录框数据清除
        loginNameDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etLoginName.setText("");
            }
        });
        //验证码输入框设置监听
        etSmsCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(etSmsCode.getText())) {
                    smsCodeDel.setVisibility(View.VISIBLE);

                } else {
                    smsCodeDel.setVisibility(View.GONE);
                }

            }
        });
        //验证码框数据清除
        smsCodeDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etSmsCode.setText("");
            }
        });
        //密码输入框设置监听
        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(etPassword.getText())) {
                    passwordDel.setVisibility(View.VISIBLE);

                } else {
                    passwordDel.setVisibility(View.GONE);
                }

            }
        });
        //密码框数据清除
        passwordDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                etPassword.setText("");
            }
        });
        //切换密码是否可见
        see_password.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (IS_SEE){
                    see_password.setImageResource(R.mipmap.not_see);
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    IS_SEE=false;
                }else{
                    see_password.setImageResource(R.mipmap.can_see);
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    IS_SEE=true;
                }
            }
        });

        //返回登录界面
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(registerActivity,LoginActivity.class);
                registerActivity.startActivity(intent);
            }
        });
    }
}
