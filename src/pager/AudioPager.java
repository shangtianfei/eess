package pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import Base.Basepage;
import Base.ClearViewParent;
/*
 * 本地音乐页面
 */
public class AudioPager extends Basepage{
	protected static final String TAG = AudioPager.class.getName();//"VideoPager"
	private TextView textView;
	public AudioPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView() {
		Log.e(TAG, "本地音乐页面被初始化了");
		textView = new TextView(context);
		textView.setTextSize(25);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.RED);
		return textView;
	}
	@Override
	public void initData() {
		super.initData();
		Log.e(TAG, "本地音乐页面的数据被初始化了");
		new ClearViewParent().ClearViewParenter(textView);//清除父类的View
		textView.setText("本地音乐页面");
	}

}
