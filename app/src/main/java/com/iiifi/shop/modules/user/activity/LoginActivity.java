package com.iiifi.shop.modules.user.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.iiifi.shop.activity.R;
import com.iiifi.shop.common.base.activity.BaseActivity;
import com.iiifi.shop.common.util.ToolBarUtil;

public class LoginActivity extends BaseActivity {

    private static boolean IS_SEE=false;


    private static final String TOOL_TITLE="登录";

    //手机号码正则表达式
    private static final String phoneRegex = "^1(3|4|5|7|8)\\d{9}";

    //密码的正则表达式
    private static final String passwordRegex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";

    /**
     * 登录名
     */
    private EditText etLoginName;
    private ImageView loginNameDel;
    /**
     * 密码
     */
    private  EditText etPassword;
    private  ImageView passwordDel;
    private  ImageView see_password;
    /**
     * 登录
     */
    private Button loginBtn;
    /**
     * 第三方登录
     */
    private ImageView ivQQ;

    private ImageView ivSina;

    private ImageView ivWeixin;

    /**
     * 忘记密码
     */
    private TextView resetPassword;
    /**
     * 快速登录
     */
    private TextView speedLogin;
    /**
     * 注册
     */
    private TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        build();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initView() {
        //设置个性化ToolBar
        ToolBarUtil.buildActivityToolBar(this,true,true,TOOL_TITLE,true,false,0);
        //登录
        etLoginName= (EditText) findViewById(R.id.et_login_name);
        loginNameDel= (ImageView) findViewById(R.id.login_name_del);
        //密码
        etPassword = (EditText) findViewById(R.id.et_paswword);
        passwordDel = (ImageView) findViewById(R.id.password_del);
        see_password = (ImageView) findViewById(R.id.see_password);
        //登录按钮
        loginBtn = (Button) findViewById(R.id.login_btn);
        //第三方登录
        ivQQ = (ImageView) findViewById(R.id.iv_qq);
        ivSina = (ImageView) findViewById(R.id.iv_sina);
        ivWeixin = (ImageView) findViewById(R.id.iv_weixin);
        //忘记密码
        resetPassword = (TextView) findViewById(R.id.reset_password);
        speedLogin = (TextView) findViewById(R.id.speed_login);
        register = (TextView) findViewById(R.id.register);
    }

    @Override
    public void initEvent() {
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
                checkLogin();
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
                checkLogin();
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
        loginBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"点击登录按钮",Toast.LENGTH_SHORT).show();
            }
        });
        //跳转到注册页面
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);

            }
        });
        //跳转到快速登录页面
        speedLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, SpeedActivity.class);
                startActivity(intent);
            }
        });
        //跳转到重置密码界面
        resetPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this, ResetPwdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void initClickEffect() {
        loginBtn.setClickable(false);
    }

    @Override
    public void initData() {

    }
    //校验注册按钮是否可点击
    public void checkLogin(){
        if(checkLoginName()&&checkPassword()){
            loginBtn.setClickable(true);
            loginBtn.setBackgroundResource(R.mipmap.login_bluebutton_selected);
        }else{
            loginBtn.setClickable(false);
            loginBtn.setBackgroundResource(R.mipmap.login_btn_one);
        }
    }
    //校验登录名是否合法
    public  boolean checkLoginName(){
        String loginName=etLoginName.getText().toString().trim();
        return (!TextUtils.isEmpty(loginName))&&loginName.matches(phoneRegex);
    }
    //校验密码是否合法
    public boolean checkPassword(){
        String password=etPassword.getText().toString().trim();
        return (!TextUtils.isEmpty(password))&&password.matches(passwordRegex);
    }
}
