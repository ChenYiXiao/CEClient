package cewedo.acts;

import cewedo.others.Global;
import cewedo.skn.SkinChangeable;
import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class BaseTabActivity extends TabActivity implements SkinChangeable{
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
		super.onDestroy();
		Global.getCurrentAcitivities().remove(this);
	}

	@Override
	public void ChangeSkin() {
	}




}
