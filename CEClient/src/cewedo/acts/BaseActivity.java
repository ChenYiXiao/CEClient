package cewedo.acts;

import cewedo.others.Global;
import cewedo.skn.SkinChangeable;
import android.app.Activity;
import android.os.Bundle;

/**基础Activity实现对换肤的接口
 * @author CYX	
 *
 */
public class BaseActivity extends Activity implements SkinChangeable{
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

	@Override
	public void ChangeSkin() {
	}



	
}
