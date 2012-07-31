package cewedo.acts;

import cewedo.others.Global;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class BaseTabActivity extends TabActivity {
protected String mCurrentSkinPakageNameString="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		Global.getCurrentAcitivities().add(this);
	}

	/* (non-Javadoc)
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Global.getCurrentAcitivities().remove(this);
	}

	public void ChangeSkin(String skinPackageString) {
		mCurrentSkinPakageNameString=skinPackageString;
		
	}
}
