package cewedo.acts;

import cewedo.others.Global;
import cewedo.skn.SkinChangeable;
import android.app.TabActivity;
import android.os.Bundle;

/**基础TabActivity类，实现换肤的接口
 * @author Administrator
 *
 */
public class BaseTabActivity extends TabActivity implements SkinChangeable{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Global.getCurrentAcitivities().add(this);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		Global.getCurrentAcitivities().remove(this);
	}

	@Override
	public void ChangeSkin() {
	}




}
