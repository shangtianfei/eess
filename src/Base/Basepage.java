package Base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 * 公共类
 * 4个页面继承此类
 * VideoPager
 * AudioPager
 * NetVideoPager
 * NetAudioPager
 */

public abstract class Basepage {
	/*
	 * 上下文
	 */
	public final Context context;
	/*
	 * 接受各个页面的实例
	 */
	public View rootview;
	public boolean isInitData;
	

	public Basepage(Context context){
		this.context = context;
		rootview = initView();
		
		
	}
	/*
	 * 强制实现特定效果，由子类实现
	 */
	
    public abstract View initView();
    
    /*
     * 当子页面需要初始化数据，联网请求数据，或者绑定数据时需要重写该方法
     */
    public void initData(){
    	
    }

  
}
