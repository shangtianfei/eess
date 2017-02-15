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
	 * 所有页面的集合
	 */
	private ArrayList<Basepage> basePages;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);
	    
	    fl_main_content = (FrameLayout) findViewById(R.id.fl_main_content);
	    rg_buttom_tga = (RadioGroup) findViewById(R.id.rg_buttom_tga);
	     
	   
	    basePages = new ArrayList<Basepage>();
	    basePages.add(new VideoPager(this));//绑定本地视频==0
	    basePages.add(new AudioPager(this));//绑定本地音乐==1	
	    basePages.add(new NetVideoPager(this));//绑定网络视频==2
	    basePages.add(new NetAudioPager(this));//绑定网络音乐==3
	    
	    //设置RadioGroup的监听
	    rg_buttom_tga.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
	    rg_buttom_tga.check(R.id.rb_video); //默认选中项目
	}
    
    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkId) {	
			switch(checkId){
			default:
				postion = 0;
				break;
			case R.id.rb_audio://本地音乐
			    postion = 1;
			    break;
			case R.id.rb_net_video://网络视频
			    postion = 2;
			    break;
			case R.id.rb_net_audio://网络音乐
			    postion = 3;
			    break;
			}
			setFragment();
 		}
/*
 * 把页面添加到Fragment中
 */
		private void setFragment() {
			//1得到fragmentManger
			FragmentManager manager = getSupportFragmentManager();
			//2.开启事务
			FragmentTransaction ft = manager.beginTransaction();
			//3.替换
			ft.replace(R.id.fl_main_content, new Fragment(){
				@Override
				public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
				    Basepage basepage = getBasepage();
				    if(basepage != null){
				    	//各个页面的视图
				    	return basepage.rootview;
				    	
				    }
					return null;
				}
			});
			//4.提交事务
			ft.commit();
		}
		/*
		 * 根据位置得到对应的页面
		 */
		protected Basepage getBasepage() {
			Basepage baspage = basePages.get(postion);
			if(baspage != null&& !baspage.isInitData){
				baspage.initData();//联网请求/绑定数据
				baspage.isInitData = true;
			}
			return baspage;
		}
    	
    }
}
