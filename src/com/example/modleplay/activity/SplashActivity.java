package com.example.modleplay.activity;

import com.example.modleplay.R;
import com.example.modleplay.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

public class SplashActivity extends Activity {
	protected static final String TAG = SplashActivity.class.getName();//"SplashActivity"
	private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				//2秒后执行这里
				//这是主线程
				startMainActivity();
				Log.e(TAG, "当前线程名称========"+Thread.currentThread().getName());
			}
		}, 2000);
    }
    private boolean isStartMain = false;
/*
 * 启动主页面，并关闭当前页“activity_splash”
 */
	protected void startMainActivity() {
		if(isStartMain != true){
			isStartMain = true;
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			//关闭当前页“activity_splash.xml”
			finish();
		}
	}
/*
 * (non-Javadoc)全屏点击事件
 * @see android.app.Activity#onTouchEvent(android.view.MotionEvent)
 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.e(TAG, "onTouchEvent========Action"+event.getAction());
		startMainActivity();
		return super.onTouchEvent(event);
	}
	@Override
	protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
		super.onDestroy();
	}
}
