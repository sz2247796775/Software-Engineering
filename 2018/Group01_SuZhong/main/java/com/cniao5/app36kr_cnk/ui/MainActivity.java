package com.cniao5.app36kr_cnk.ui;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.adapter.LeftItemAdapter;
import com.cniao5.app36kr_cnk.common.DefineView;
import com.cniao5.app36kr_cnk.ui.base.BaseActivity;
import com.cniao5.app36kr_cnk.widget.DragLayout;
import com.nineoldandroids.view.ViewHelper;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
/**
 * 当前类注释:主Activity类
 * ProjectName：App36Kr
 * Description：
 */
    public class MainActivity extends BaseActivity implements DefineView{
        public DragLayout getDrag_layout() {
            return drag_layout;
        }
    private Button mCancleButton;
    private DragLayout drag_layout;
    private Button fabu;
        private ImageView top_bar_icon;
    private ListView lv_left_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStatusBar();
        initView();
        initValidata();
        initListener();
        bindData();

        lv_left_main.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                if (arg2==1){
                    Intent intent_create = new Intent(MainActivity.this,createTask.class) ;    //切换Login Activity至User Activity
                startActivity(intent_create);
                finish();}
            }

        }) ;
    }
    public void initView() {
        drag_layout = (DragLayout) findViewById(R.id.drag_layout);
        top_bar_icon = (ImageView) findViewById(R.id.top_bar_icon);
        mCancleButton = (Button) findViewById(R.id.login_btn_register);
        lv_left_main=(ListView)findViewById(R.id.lv_left_main);

    }

    @Override
    public void initValidata() {
        lv_left_main.setAdapter(new LeftItemAdapter());
    }
    @Override
    public void initListener() {
        drag_layout.setDragListener(new CustomDragListener());
        top_bar_icon.setOnClickListener(new CustomOnClickListener());
        mCancleButton.setOnClickListener(new CustomOnClickListener());
    }
    @Override
    public void bindData() {

    }
    class CustomDragListener implements DragLayout.DragListener{

        /**
         * 界面打开
         */
        @Override
        public void onOpen() {

        }

        /**
         * 界面关闭
         */
        @Override
        public void onClose() {

        }

        /**
         * 界面进行滑动
         * @param percent
         */
        @Override
        public void onDrag(float percent) {
              ViewHelper.setAlpha(top_bar_icon,1-percent);
        }
    }
    class CustomOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.top_bar_icon:
                        drag_layout.open();
                        break;
                    case R.id.login_btn_register:                             //登录界面的注销按钮
                   Intent intent_Login_to_reset = new Intent(MainActivity.this,Login.class) ;    //切换Login Activity至User Activity
                    startActivity(intent_Login_to_reset);
                    finish();
                    break;
                }
        }
    }

}
