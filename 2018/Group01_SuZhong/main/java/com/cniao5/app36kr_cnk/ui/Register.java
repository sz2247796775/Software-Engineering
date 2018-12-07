package com.cniao5.app36kr_cnk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cniao5.app36kr_cnk.R;

public class Register extends AppCompatActivity {
    private EditText mAccount;                        //用户名编辑
    private EditText mPwd;                            //密码编辑
    private EditText mPwdCheck;                       //密码编辑
    private Button mSureButton;                       //确定按钮
    private Button mCancelButton;                     //取消按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mAccount = (EditText) findViewById(R.id.resetpwd_edit_name);
        mPwd = (EditText) findViewById(R.id.resetpwd_edit_pwd_old);
        mPwdCheck = (EditText) findViewById(R.id.resetpwd_edit_pwd_new);

        mSureButton = (Button) findViewById(R.id.register_btn_sure);
        mCancelButton = (Button) findViewById(R.id.register_btn_cancel);

        mSureButton.setOnClickListener(m_register_Listener);      //注册界面两个按钮的监听事件
        mCancelButton.setOnClickListener(m_register_Listener);



    }
    View.OnClickListener m_register_Listener = new View.OnClickListener() {    //不同按钮按下的监听事件选择
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register_btn_sure:                       //确认按钮的监听事件
                    register_check();
                    break;
                case R.id.register_btn_cancel:                     //取消按钮的监听事件,由注册界面返回登录界面
                    Intent intent_Register_to_Login = new Intent(Register.this,Login.class) ;    //切换User Activity至Login Activity
                    startActivity(intent_Register_to_Login);
                    finish();
                    break;
            }
        }
    };
    public void register_check() {                                //确认按钮的监听事件
        if (isUserNameAndPwdValid()) {
            final String userName = mAccount.getText().toString().trim();
            final String userPwd = mPwd.getText().toString().trim();
            final String userPwdCheck = mPwdCheck.getText().toString().trim();
            //两次密码输入不一样
            if(userPwd.equals(userPwdCheck)==false){

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Register.this, getString(R.string.pwd_not_the_same),Toast.LENGTH_SHORT).show();
                    }
                });
                return;
            }



            new Thread(){
                public void run(){

                    int result = RegisterService.register(userName,userPwd);
                    //用户已经存在时返回，给出提示文字
                    if(result == -1){

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Register.this, getString(R.string.name_already_exist, userName),Toast.LENGTH_SHORT).show();
                            }
                        });
                        return ;
                    }


                        if (result == 0) {

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Register.this, getString(R.string.register_fail),Toast.LENGTH_SHORT).show();
                                }
                            });

                        }else{

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Register.this, getString(R.string.register_success),Toast.LENGTH_SHORT).show();//
                                }
                            });

                            Intent intent_Register_to_Login = new Intent(Register.this,Login.class) ;    //切换User Activity至Login Activity
                            startActivity(intent_Register_to_Login);
                            finish();
                        }
                    }
            }.start();

        }
    }

    public boolean isUserNameAndPwdValid() {
        if (mAccount.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.account_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (mPwd.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if(mPwdCheck.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.pwd_check_empty),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
