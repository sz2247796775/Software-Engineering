package com.cniao5.app36kr_cnk.ui;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.cniao5.app36kr_cnk.R;

public class createTask extends AppCompatActivity{
    private EditText mTaskTi;                        //标题
    private EditText mTaskCo;                            //正文
    private EditText mTaskMo;                        //金额
    private Button mSureButton;                       //确定按钮
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createtask);
        mTaskTi = (EditText) findViewById(R.id.create_task_ti);
        mTaskCo = (EditText) findViewById(R.id.create_task_con);
        mTaskMo = (EditText) findViewById(R.id.topay);

        mSureButton = (Button) findViewById(R.id.create_sure);

        mSureButton.setOnClickListener(m_create_Listener);      //按钮的监听事件

    };
    View.OnClickListener m_create_Listener = new View.OnClickListener() {    //不同按钮按下的监听事件选择
        public void onClick(View v) {
            register_check();
        };
    };
    public void register_check() {                                //确认按钮的监听事件
        if (isSomeValid()) {
            new Thread(){
                public void run(){                            runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(createTask.this, getString(R.string.cre_succ),Toast.LENGTH_SHORT).show();//
                    }
                });

                    Intent intent_Register_to_Main = new Intent(createTask.this,MainActivity.class) ;    //切换User Activity至Login Activity
                        startActivity(intent_Register_to_Main);
                        finish();
                }
            }.start();

        }
    }
    public boolean isSomeValid() {
        if (mTaskTi.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.ti_no),
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (mTaskMo.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.mo_no),
                    Toast.LENGTH_SHORT).show();
            return false;
        }else if(mTaskCo.getText().toString().trim().equals("")) {
            Toast.makeText(this, getString(R.string.co_no),
                    Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}