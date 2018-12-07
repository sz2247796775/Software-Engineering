package com.cniao5.app36kr_cnk.ui;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.cniao5.app36kr_cnk.R;
import com.cniao5.app36kr_cnk.ui.base.BaseActivity;
import com.cniao5.app36kr_cnk.widget.CustomVideoView;

/**
 * 当前类注释:启动欢迎界面
 * ProjectName：App36Kr
 * Author:<a href="http://www.cniao5.com">菜鸟窝</a>
 * Description：
 */
public class WelcomeActivity extends BaseActivity {
    private Button welcome_button;
    private CustomVideoView welcome_videoview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        welcome_button=(Button)this.findViewById(R.id.welcome_button);
        welcome_videoview = (CustomVideoView) this.findViewById(R.id.welcome_videoview);
        welcome_videoview.setVideoURI(Uri.parse("android.resource://"+this.getPackageName()+"/"+R.raw.kr36));
        welcome_videoview.start();
        welcome_videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcome_videoview.start();

            }
        });
        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(welcome_videoview.isPlaying()){
                    welcome_videoview.stopPlayback();
                    welcome_videoview=null;
                }
                openActivity(Login.class);
                WelcomeActivity.this.finish();
            }
        });
    }

    private  String getAppVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(this.getPackageName(), 0);
            versionName = packageInfo.versionName;
            if (TextUtils.isEmpty(versionName)) {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
