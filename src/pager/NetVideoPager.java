package pager;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import Base.Basepage;
import Base.ClearViewParent;
/*
 * ������Ƶҳ��
 */
public class NetVideoPager extends Basepage{
	protected static final String TAG = NetVideoPager.class.getName();//"VideoPager"
	private TextView textView;
	public NetVideoPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView() {
		Log.e(TAG, "������Ƶҳ�汻��ʼ����");
		textView = new TextView(context);
		textView.setTextSize(25);
		textView.setGravity(Gravity.CENTER);
		textView.setTextColor(Color.RED);
		return textView;
	}
	@Override
	public void initData() {
		super.initData();
		Log.e(TAG, "������Ƶҳ������ݱ���ʼ����");
		new ClearViewParent().ClearViewParenter(textView);//��������View
		textView.setText("������Ƶҳ��");
	}

}
