package com.xxp.jiyi.pro.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.animation.AlphaAnimation;

import com.xxp.jiyi.R;

public class SplashActivity extends BaseActivity {

    private final int WHAT_GOMAIN = 0x11;
    private final int DELAYED_TIME = 4000;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_GOMAIN:
                    goMain();
                    break;
            }


            super.handleMessage(msg);
        }
    };

    @Override
    protected void init() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        getWindow().getDecorView().findViewById(android.R.id.content).setAnimation(alphaAnimation);
        mHandler.sendEmptyMessageDelayed(WHAT_GOMAIN, DELAYED_TIME);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    //to mainActivity
    private void goMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
