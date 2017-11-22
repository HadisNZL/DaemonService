package com.hadis.daemonservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hadis.daemonservice.service.BackgroundService;
import com.hadis.daemonservice.service.GrayService;
import com.hadis.daemonservice.service.WhiteService;

/**
 * 进程保活方法 1：黑色保活 2.白色保活 3.灰色保活（good）
 * 微信、qq、支付宝、陌陌全部应用灰色保活
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG = MainActivity.class.getSimpleName();
    /**
     * 黑色唤醒广播的action
     */
    private final static String BLACK_WAKE_ACTION = "com.wake.black";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_white).setOnClickListener(this);
        findViewById(R.id.btn_gray).setOnClickListener(this);
        findViewById(R.id.btn_black).setOnClickListener(this);
        findViewById(R.id.btn_background_service).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_white://系统正常的前台Service，白色保活手段
                Intent whiteIntent = new Intent(getApplicationContext(), WhiteService.class);
                startService(whiteIntent);
                break;
            case R.id.btn_gray://利用系统漏洞，灰色保活手段（API < 18 和 API >= 18 两种情况）
                Intent grayIntent = new Intent(getApplicationContext(), GrayService.class);
                startService(grayIntent);
                break;
            case R.id.btn_black://拉帮结派，黑色保活手段，利用广播唤醒队友
                Intent blackIntent = new Intent();
                blackIntent.setAction(BLACK_WAKE_ACTION);
                sendBroadcast(blackIntent);
                break;
            case R.id.btn_background_service://普通进程后台
                Intent bgIntent = new Intent(getApplicationContext(), BackgroundService.class);
                startService(bgIntent);
                break;
        }
    }
}
