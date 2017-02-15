package Base;

import android.view.ViewGroup;
import android.widget.TextView;
/*
 * Çå³ýView¸¸Àà
 */
public class ClearViewParent {
	  public void ClearViewParenter(TextView textView){
	    	if(textView.getParent()!=null){
		    	((ViewGroup)textView.getParent()).removeView(textView);
		    }
	    }
}
