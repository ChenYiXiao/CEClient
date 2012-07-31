package cewedo.acts;

import cewedo.menu.MenuManager;
import cewedo.others.CEConfiguration;
import cewedo.others.CommonOperation;
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

public class HomeActivity extends BaseActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		setTitle("da");
		ChangeSkin();
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			CommonOperation.showExitDialog(this);
		}
		return super.onKeyDown(keyCode, event);
	}



	@Override
	public void ChangeSkin() {
		SkinManager skinManager;
		skinManager = new SkinManager(CEConfiguration.getSkinPackageName(this), this);
		RadioGroup mainRadioGroup = (RadioGroup) findViewById(R.id.main_radio);
		mainRadioGroup.setBackgroundDrawable(skinManager
				.getDrawableResource(R.drawable.home_bg_top));
		RadioButton leftRadioButton = (RadioButton) findViewById(R.id.home_radio_left);
		RadioButton rightRadioButton = (RadioButton) findViewById(R.id.home_radio_right);

		leftRadioButton.setBackgroundDrawable(skinManager
				.getDrawableResource(R.drawable.home_top_btn_bg));
		rightRadioButton.setBackgroundDrawable(skinManager
				.getDrawableResource(R.drawable.home_top_btn_bg));
		super.ChangeSkin();
		
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		MenuManager.doMenuSelect(featureId, item, this);
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuManager.getMenu(menu, R.menu.mainmenu, this);
		return super.onCreateOptionsMenu(menu);
	}
}
