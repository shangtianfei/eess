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
				//2���ִ������
				//�������߳�
				startMainActivity();
				Log.e(TAG, "��ǰ�߳�����========"+Thread.currentThread().getName());
			}
		}, 2000);
    }
    private boolean isStartMain = false;
/*
 * ������ҳ�棬���رյ�ǰҳ��activity_splash��
 */
	protected void startMainActivity() {
		if(isStartMain != true){
			isStartMain = true;
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
			//�رյ�ǰҳ��activity_splash.xml��
			finish();
		}
	}
/*
 * (non-Javadoc)ȫ������¼�
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
