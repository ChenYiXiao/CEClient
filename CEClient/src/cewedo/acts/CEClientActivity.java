package cewedo.acts;

import cewedo.menu.MenuManager;
import cewedo.others.CEConfiguration;
import cewedo.skn.SkinChangeable;
import cewedo.skn.SkinManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.LocalActivityManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TabHost;

public class CEClientActivity extends BaseTabActivity implements
		OnCheckedChangeListener, SkinChangeable {

	private TabHost mTabHost;
	private Intent mAIntent;
	private Intent mBIntent;
	private Intent mCIntent;
	private Intent mDIntent;
	private Intent mEIntent;

	private RadioGroup bottomRadioGroup;
	private RadioButton homeRadioButton;
	private RadioButton squareRadioButton;
	private RadioButton messageRadioButton;
	private RadioButton friendRadioButtond;
	private RadioButton moreRadioButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		this.mAIntent = new Intent(this, HomeActivity.class);
		this.mBIntent = new Intent(this, HomeActivity.class);
		this.mCIntent = new Intent(this, HomeActivity.class);
		this.mDIntent = new Intent(this, HomeActivity.class);
		this.mEIntent = new Intent(this, HomeActivity.class);

		bottomRadioGroup = (RadioGroup) findViewById(R.id.main_radio);
		homeRadioButton = (RadioButton) findViewById(R.id.radio_home);
		homeRadioButton.setOnCheckedChangeListener(this);
		squareRadioButton = ((RadioButton) findViewById(R.id.radio_square));
		squareRadioButton.setOnCheckedChangeListener(this);
		messageRadioButton = ((RadioButton) findViewById(R.id.radio_message));
		messageRadioButton.setOnCheckedChangeListener(this);
		friendRadioButtond = ((RadioButton) findViewById(R.id.radio_friend));
		friendRadioButtond.setOnCheckedChangeListener(this);
		moreRadioButton = ((RadioButton) findViewById(R.id.radio_more));
		moreRadioButton.setOnCheckedChangeListener(this);

		setupIntent();
		ChangeSkin();
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			switch (buttonView.getId()) {
			case R.id.radio_home:
				this.mTabHost.setCurrentTabByTag("A_TAB");
				break;
			case R.id.radio_square:
				this.mTabHost.setCurrentTabByTag("B_TAB");
				break;
			case R.id.radio_message:
				this.mTabHost.setCurrentTabByTag("C_TAB");
				break;
			case R.id.radio_friend:
				ChangeSkin();
				this.mTabHost.setCurrentTabByTag("D_TAB");
				break;
			case R.id.radio_more:
				ChangeSkin();
				this.mTabHost.setCurrentTabByTag("MORE_TAB");
				break;
			}
		}

	}

	
	
	private void setupIntent() {
		this.mTabHost = getTabHost();
		TabHost localTabHost = this.mTabHost;

		localTabHost.addTab(buildTabSpec("A_TAB", R.string.main_home,
				R.drawable.main_radio_home, this.mAIntent));

		localTabHost.addTab(buildTabSpec("B_TAB", R.string.main_messages,
				R.drawable.main_radio_square, this.mBIntent));

		localTabHost.addTab(buildTabSpec("C_TAB", R.string.main_messages,
				R.drawable.main_radio_message, this.mCIntent));

		localTabHost.addTab(buildTabSpec("D_TAB", R.string.main_friends,
				R.drawable.main_radio_friend, this.mDIntent));

		localTabHost.addTab(buildTabSpec("MORE_TAB", R.string.main_more,
				R.drawable.main_radio_more, this.mEIntent));

		localTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
				
				Context ct = (mTabHost.getCurrentView().getContext());
				((SkinChangeable)ct).ChangeSkin();
				if(tabId=="D_TAB")
				{
					((SkinChangeable)ct).ChangeSkin();
				}
			}
		});
	}

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon,
			final Intent content) {
		return this.mTabHost
				.newTabSpec(tag)
				.setIndicator(getString(resLabel),
						getResources().getDrawable(resIcon))
				.setContent(content);
	}

	@Override
	public void ChangeSkin() {
			SkinManager skinManager = new SkinManager(CEConfiguration.getSkinPackageName(this),
					CEClientActivity.this);
			// Ìæ»»ÆäËû±³¾°
			this.mTabHost.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.main_bg_main));
			bottomRadioGroup.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.main_bottom_bg));
			// Ìæ»»µ×²¿°´Å¥µÄ±³¾°
			homeRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			squareRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			messageRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			friendRadioButtond.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			moreRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			// Ìæ»»µ×²¿°´Å¥
			homeRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_home), null,
					null);
			squareRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_square),
					null, null);
			messageRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_message),
					null, null);
			friendRadioButtond.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_friend),
					null, null);
			moreRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_more), null,
					null);
		super.ChangeSkin();
	}
  

	 @Override
     public boolean onKeyUp(int keyCode, KeyEvent event) {
         if(keyCode==KeyEvent.KEYCODE_MENU) {
            this.getLocalActivityManager().getCurrentActivity().openOptionsMenu();
         }
        return super.onKeyDown(keyCode, event);
     }
	
}
