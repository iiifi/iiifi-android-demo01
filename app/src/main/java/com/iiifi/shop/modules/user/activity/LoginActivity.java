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
import com.iiifi.shop.common.util.CheckUtils;
import com.iiifi.shop.common.util.ToolBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends BaseActivity {

    private static boolean IS_SEE=false;


    private static final String TOOL_TITLE="登录";

    /**
     * 登录名
     */
    @BindView(R.id.et_login_name)
    EditText etLoginName;
    @BindView(R.id.login_name_del)
    ImageView loginNameDel;
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
     * 登录
     */
    @BindView(R.id.login_btn)
    Button loginBtn;

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
                if (!TextUtils.isEmpty(etLoginName.getText())) {
                    loginNameDel.setVisibility(View.VISIBLE);
                } else {
                    loginNameDel.setVisibility(View.GONE);
                }
                checkLogin();
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
    }

    @Override
    public void initClickEffect() {
        loginBtn.setClickable(false);
    }

    @Override
    public void initData() {

    }

    //登录框数据清除
    @OnClick(R.id.login_name_del)
    public void cleanEtLoginName() {
        etLoginName.setText("");
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
    @OnClick(R.id.login_btn)
    public void login(View v) {
        Toast.makeText(v.getContext(),"点击登录按钮",Toast.LENGTH_SHORT).show();
    }
    //跳转到注册页面
    @OnClick(R.id.register)
    public void openRegisterActivity() {
        openActivity(RegisterActivity.class);
    }
    //跳转到快速登录页面
    @OnClick(R.id.speed_login)
    public void openSpeedActivity() {
        openActivity(SpeedActivity.class);
    }
    //跳转到重置密码界面
    @OnClick(R.id.reset_password)
    public void openResetPwdActivity() {
        openActivity(ResetPwdActivity.class);
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
        return CheckUtils.checkPhone(loginName);
    }
    //校验密码是否合法
    public boolean checkPassword(){
        String password=etPassword.getText().toString().trim();
        return CheckUtils.checkPassword(password);
    }
}
