package cewedo.acts;

import cewedo.others.CEConfiguration;
import cewedo.skn.SkinChangeable;
import cewedo.skn.SkinManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TabHost;

/**主界面，带有导航框架
 * @author Administrator
 *
 */
public class CEClientActivity extends BaseTabActivity implements
		OnCheckedChangeListener, SkinChangeable {

	private TabHost mTabHost;
	private Intent mHomeIntent;
	private Intent mBIntent;
	private Intent mCIntent;
	private Intent mDIntent;
	private Intent mEIntent;

	private RadioGroup mBottomRadioGroup;
	private RadioButton mHomeRadioButton;
	private RadioButton mSquareRadioButton;
	private RadioButton mMessageRadioButton;
	private RadioButton mFriendRadioButtond;
	private RadioButton mMoreRadioButton;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		this.mHomeIntent = new Intent(this, HomeActivity.class);
		this.mBIntent = new Intent(this, HomeActivity.class);
		this.mCIntent = new Intent(this, HomeActivity.class);
		this.mDIntent = new Intent(this, HomeActivity.class);
		this.mEIntent = new Intent(this, HomeActivity.class);
        //找到全部的Id
		mBottomRadioGroup = (RadioGroup) findViewById(R.id.main_radio);
		mHomeRadioButton = (RadioButton) findViewById(R.id.radio_home);
		mHomeRadioButton.setOnCheckedChangeListener(this);
		mSquareRadioButton = ((RadioButton) findViewById(R.id.radio_square));
		mSquareRadioButton.setOnCheckedChangeListener(this);
		mMessageRadioButton = ((RadioButton) findViewById(R.id.radio_message));
		mMessageRadioButton.setOnCheckedChangeListener(this);
		mFriendRadioButtond = ((RadioButton) findViewById(R.id.radio_friend));
		mFriendRadioButtond.setOnCheckedChangeListener(this);
		mMoreRadioButton = ((RadioButton) findViewById(R.id.radio_more));
		mMoreRadioButton.setOnCheckedChangeListener(this);

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
				R.drawable.main_radio_home, this.mHomeIntent));

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
			// 替换其他背景
			this.mTabHost.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.main_bg_main));
			mBottomRadioGroup.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.main_bottom_bg));
			// 替换底部按钮的背景
			mHomeRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			mSquareRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			mMessageRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			mFriendRadioButtond.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			mMoreRadioButton.setBackgroundDrawable(skinManager
					.getDrawableResource(R.drawable.home_btn_bg));
			// 替换底部按钮
			mHomeRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_home), null,
					null);
			mSquareRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_square),
					null, null);
			mMessageRadioButton.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_message),
					null, null);
			mFriendRadioButtond.setCompoundDrawables(null, skinManager
					.getRectDrawableResource(R.drawable.main_radio_friend),
					null, null);
			mMoreRadioButton.setCompoundDrawables(null, skinManager
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
