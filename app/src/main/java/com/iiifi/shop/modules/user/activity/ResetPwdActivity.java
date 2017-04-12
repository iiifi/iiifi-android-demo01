package com.iiifi.shop.modules.user.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Bundle;
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
import com.iiifi.shop.common.util.CheckUtils;
import com.iiifi.shop.common.util.ToolBarUtil;
import com.iiifi.shop.modules.syscenter.activity.CommonWebActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetPwdActivity extends BaseActivity {

    private static boolean IS_SEE=false;

    /**
     * title
     */
    private static final String TOOL_TITLE="重置密码";

    //发送验证码定时器
    private VerifyCodeTimer timer;

    /**
     * 登录名
     */
    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.login_name_del)
    ImageView loginNameDel;

    /**
     * 验证码
     */
    @BindView(R.id.et_sms_code)
    EditText etSmsCode;
    @BindView(R.id.sms_code_del)
    ImageView smsCodeDel;
    @BindView(R.id.send_code)
    TextView sendCode;
    /**
     * 密码
     */
    @BindView(R.id.et_paswword)
    EditText etPassword;
    @BindView(R.id.password_del)
    ImageView passwordDel;
    @BindView(R.id.see_password)
    ImageView see_password;

    /**
     * 重置密码
     */
    @BindView(R.id.reset_pwd)
    Button resetPwdBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        //编译控件
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
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {
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
                String phoneNumber=etLoginName.getText().toString().trim();
                if (!TextUtils.isEmpty(phoneNumber)) {
                    loginNameDel.setVisibility(View.VISIBLE);
                    //根据手机号状态判发送验证码是否可点击
                    if(checkLoginName()&&isCreate()){
                        sendCode.setClickable(true);
                        etLoginName.setVisibility(View.VISIBLE);
                        sendCode.setTextColor(getResources().getColor(R.color.text_color_getverfy));
                        sendCode.setBackgroundResource(R.mipmap.login_testgetcode_box);
                    }else{
                        sendCode.setClickable(false);
                        sendCode.setTextColor(getResources().getColor(R.color.text_color_gray));
                        sendCode.setBackgroundResource(R.mipmap.login_register_code);
                    }
                } else {
                    loginNameDel.setVisibility(View.GONE);
                }
                //判断注册按钮是否可点击
                checkRegister();
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
                //判断注册按钮是否可点击
                checkRegister();
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
                //判断注册按钮是否可点击
                checkRegister();
            }
        });
    }

    @Override
    public void initClickEffect() {
        sendCode.setClickable(false);
        resetPwdBtn.setClickable(false);
    }

    @Override
    public void initData() {

    }

    //登录框数据清除
    @OnClick(R.id.login_name_del)
    public void cleanLoginName() {
        etLoginName.setText("");
    }

    //发送验证码事件
    @OnClick(R.id.send_code)
    public void sendCode() {
        //判断登录名是否合法
        if(!checkLoginName()){
            sendCode.setClickable(false);
        }else{
            etLoginName.clearFocus();
            etSmsCode.requestFocus();
            //发送验证码处理事件
            sendCode.setClickable(false);
            timer = new VerifyCodeTimer(6000, 1000);
            timer.start();
        }
    }

    //验证码框数据清除
    @OnClick(R.id.sms_code_del)
    public void cleanSmsCode() {
        etSmsCode.setText("");
    }

    //密码框数据清除
    @OnClick(R.id.password_del)
    public void cleanEtPassword() {
        etPassword.setText("");
    }

    //切换密码是否可见
    @OnClick(R.id.see_password)
    public void switchSee() {
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
    //重置密码按钮
    @OnClick(R.id.reset_pwd)
    public void resetPwd(View v) {
        Toast.makeText(v.getContext(),"点击重置密码按钮",Toast.LENGTH_SHORT).show();
    }

    //返回登录界面
    @OnClick(R.id.login_btn)
    public void backLoginActivity(View v) {
        finish();
    }

    //跳转到快速登录页面
    @OnClick(R.id.speed_login)
    public void openSpeedActivity() {
        openActivity(SpeedActivity.class);
    }


    //校验注册按钮是否可点击
    public void checkRegister(){
        if(checkLoginName()&&checkPassword()&&checkSmsCode()){
            resetPwdBtn.setClickable(true);
            resetPwdBtn.setBackgroundResource(R.mipmap.login_bluebutton_selected);
        }else{
            resetPwdBtn.setClickable(false);
            resetPwdBtn.setBackgroundResource(R.mipmap.login_btn_one);
        }
    }
    //校验登录名是否合法
    public  boolean checkLoginName(){
        String loginName=etLoginName.getText().toString().trim();
        return CheckUtils.checkPhone(loginName);
    }
    //校验密码是否合法
    public boolean checkPassword(){
        String password=etPassword.getText().toString().trim();
        return CheckUtils.checkPassword(password);
    }
    //校验验证码是否合法
    public boolean checkSmsCode(){
        String smsCode=etSmsCode.getText().toString().trim();
        return CheckUtils.checkSmsCode(smsCode);
    }
    //判断定时器是否被创建
    private boolean isCreate() {
        if (timer == null) {
            return true;
        }
        return false;
    }

    /**
     * 获取验证码的定时器
     */
    class VerifyCodeTimer extends CountDownTimer {
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        public VerifyCodeTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
            //定时器被创建的时候获取验证码的按钮不能点击
            sendCode.setClickable(false);
//            et_phone.setEnabled(false);
            sendCode.setTextColor(resetPwdBtn.getResources().getColor(R.color.text_color_gray));
            sendCode.setBackgroundResource(R.mipmap.login_register_code);
        }


        //计时开始时的方法
        @Override
        public void onTick(long millisUntilFinished) {
            sendCode.setText(millisUntilFinished / 1000 + "s");
            sendCode.setClickable(false);
        }

        //计时结束后的方法
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void onFinish() {
            //将获取验证码变成可点击的
            if(checkLoginName()){
                sendCode.setClickable(true);
                sendCode.setText("重新获取");
                sendCode.setTextColor(getResources().getColor(R.color.text_color_getverfy));
                sendCode.setBackgroundResource(R.mipmap.login_testgetcode_box);
            }else {
                sendCode.setText("获取验证码");
            }
            timer=null;
        }
    }
}
