package cn.edu.cqu.caijimovie.activities;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.utils.ThreadUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //Todo:获取是否有存有的账号密码来进行登录
        //如果没有,进入登录界面
        Intent intent = new Intent(SplashActivity.this, SignUpInActivity.class);
        startActivity(intent);
        finish();
        ThreadUtil.runInThread(new Runnable() {


            @Override
            public void run() {
                //停留2s
                SystemClock.sleep(2000);

                //如果有,加载主界面


            }
        });
    }



}
