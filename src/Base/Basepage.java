package Base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/*
 * ������
 * 4��ҳ��̳д���
 * VideoPager
 * AudioPager
 * NetVideoPager
 * NetAudioPager
 */

public abstract class Basepage {
	/*
	 * ������
	 */
	public final Context context;
	/*
	 * ���ܸ���ҳ���ʵ��
	 */
	public View rootview;
	public boolean isInitData;
	

	public Basepage(Context context){
		this.context = context;
		rootview = initView();
		
		
	}
	/*
	 * ǿ��ʵ���ض�Ч����������ʵ��
	 */
	
    public abstract View initView();
    
    /*
     * ����ҳ����Ҫ��ʼ�����ݣ������������ݣ����߰�����ʱ��Ҫ��д�÷���
     */
    public void initData(){
    	
    }

  
}
