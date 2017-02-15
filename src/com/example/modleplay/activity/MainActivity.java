package com.example.modleplay.activity;

import java.util.ArrayList;
import pager.AudioPager;
import pager.NetAudioPager;
import pager.NetVideoPager;
import pager.VideoPager;
import Base.Basepage;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.example.modleplay.R;

public class MainActivity extends FragmentActivity{
	private FrameLayout fl_main_content;
	private RadioGroup rg_buttom_tga;
	private int postion;
	/*
	 * ����ҳ��ļ���
	 */
	private ArrayList<Basepage> basePages;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    fl_main_content = (FrameLayout) findViewById(R.id.fl_main_content);
	    rg_buttom_tga = (RadioGroup) findViewById(R.id.rg_buttom_tga);
	     
	   
	    basePages = new ArrayList<Basepage>();
	    basePages.add(new VideoPager(this));//�󶨱�����Ƶ==0
	    basePages.add(new AudioPager(this));//�󶨱�������==1	
	    basePages.add(new NetVideoPager(this));//��������Ƶ==2
	    basePages.add(new NetAudioPager(this));//����������==3
	    
	    //����RadioGroup�ļ���
	    rg_buttom_tga.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
	    rg_buttom_tga.check(R.id.rb_video); //Ĭ��ѡ����Ŀ
	}
    
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkId) {	
			switch(checkId){
			default:
				postion = 0;
				break;
			case R.id.rb_audio://��������
			    postion = 1;
			    break;
			case R.id.rb_net_video://������Ƶ
			    postion = 2;
			    break;
			case R.id.rb_net_audio://��������
			    postion = 3;
			    break;
			}
			setFragment();
 		}
/*
 * ��ҳ����ӵ�Fragment��
 */
		private void setFragment() {
			//1�õ�fragmentManger
			FragmentManager manager = getSupportFragmentManager();
			//2.��������
			FragmentTransaction ft = manager.beginTransaction();
			//3.�滻
			ft.replace(R.id.fl_main_content, new Fragment(){
				@Override
				public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
				    Basepage basepage = getBasepage();
				    if(basepage != null){
				    	//����ҳ�����ͼ
				    	return basepage.rootview;
				    	
				    }
					return null;
				}
			});
			//4.�ύ����
			ft.commit();
		}
		/*
		 * ����λ�õõ���Ӧ��ҳ��
		 */
		protected Basepage getBasepage() {
			Basepage baspage = basePages.get(postion);
			if(baspage != null&& !baspage.isInitData){
				baspage.initData();//��������/������
				baspage.isInitData = true;
			}
			return baspage;
		}
    	
    }
}
