package cewedo.acts;

import cewedo.menu.MenuManager;
import cewedo.skn.SkinChangeable;
import cewedo.skn.SkinManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends Activity implements SkinChangeable {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		setTitle("da");
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onKeyUp(int, android.view.KeyEvent)
	 */
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		 
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			 showExitDialog();
		}
		return super.onKeyDown(keyCode, event) ;
	}

	private void showExitDialog() {
		final Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("确认");
		builder.setMessage("确定退出？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				System.exit(0);
			}
		});
		builder.setNegativeButton("取消", null);
		builder.create().show();
		
	}
	@Override
	public void ChangeSkin(String skinNameString) {
		Toast.makeText(this,"换肤中", 2000).show();
		SkinManager skinManager;
		try {
			skinManager = new SkinManager(skinNameString, this);
			RadioGroup mainRadioGroup=(RadioGroup)findViewById(R.id.main_radio);
			mainRadioGroup.setBackgroundDrawable(skinManager.getDrawableResource(R.drawable.home_bg_top));
			RadioButton leftRadioButton=(RadioButton)findViewById(R.id.home_radio_left);
			RadioButton rightRadioButton=(RadioButton)findViewById(R.id.home_radio_right);
			
			leftRadioButton.setBackgroundDrawable(skinManager.getDrawableResource(R.drawable.home_top_btn_bg));
			rightRadioButton.setBackgroundDrawable(skinManager.getDrawableResource(R.drawable.home_top_btn_bg));

		} catch (NameNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onMenuItemSelected(int, android.view.MenuItem)
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		MenuManager.doMenuSelect(featureId, item, this);
		return super.onMenuItemSelected(featureId, item);
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuManager.getMenu(menu, R.menu.mainmenu, this);
		return super.onCreateOptionsMenu(menu);
	}
}
