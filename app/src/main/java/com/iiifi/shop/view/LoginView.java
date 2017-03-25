package com.iiifi.shop.view;

import android.app.Activity;
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
import android.widget.Toast;

import com.iiifi.shop.activity.LoginActivity;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.activity.RegisterActivity;

/**
 * Created by dmm on 2017/3/24.
 */

public class LoginView{

    private static boolean IS_SEE=false;

    private LoginActivity loginActivity;
    /**
     * 登录名
     */
    private  EditText etLoginName;
    private  ImageView loginNameDel;
    /**
     * 密码
     */
    private  EditText etPassword;
    private  ImageView passwordDel;
    private  ImageView see_password;

    /**
     * 忘记密码
     */
    private TextView resetPassword;
    /**
     * 快速登录
     */
    private TextView speedLogin;
    /**
     * 登录
     */
    private Button loginBtn;
    /**
     * 注册
     */
    private TextView register;
    /**
     * 第三方登录
     */
    private ImageView ivQQ;

    private ImageView ivSina;

    private ImageView ivWeixin;

    public LoginView(LoginActivity loginActivity){
        this.loginActivity=loginActivity;
        initView(loginActivity);
        initEvent();
    }

    /**
     * 初始化控件
     * @param loginActivity
     */
    public  void initView(LoginActivity loginActivity){
        etLoginName= (EditText) loginActivity.findViewById(R.id.et_login_name);
        loginNameDel= (ImageView) loginActivity.findViewById(R.id.login_name_del);
        etPassword = (EditText) loginActivity.findViewById(R.id.et_paswword);
        passwordDel = (ImageView) loginActivity.findViewById(R.id.password_del);
        see_password = (ImageView) loginActivity.findViewById(R.id.see_password);
        resetPassword = (TextView) loginActivity.findViewById(R.id.reset_password);
        speedLogin = (TextView) loginActivity.findViewById(R.id.speed_login);
        loginBtn = (Button) loginActivity.findViewById(R.id.login_btn);
        register = (TextView) loginActivity.findViewById(R.id.register);
        ivQQ = (ImageView) loginActivity.findViewById(R.id.iv_qq);
        ivSina = (ImageView) loginActivity.findViewById(R.id.iv_sina);
        ivWeixin = (ImageView) loginActivity.findViewById(R.id.iv_weixin);
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
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginActivity, RegisterActivity.class);
                loginActivity.startActivity(intent);

            }
        });
    }

}
