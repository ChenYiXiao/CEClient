package cewedo.acts;

import android.app.TabActivity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.Window; 
import android.widget.CompoundButton; 
import android.widget.RadioButton; 
import android.widget.CompoundButton.OnCheckedChangeListener; 
import android.widget.TabHost; 

public class CEClientActivity extends TabActivity implements OnCheckedChangeListener{
     
    private TabHost mTabHost; 
    private Intent mAIntent; 
    private Intent mBIntent; 
    private Intent mCIntent; 
    private Intent mDIntent; 
    private Intent mEIntent; 
     
    /** Called when the activity is first created. */ 
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        requestWindowFeature(Window.FEATURE_NO_TITLE); 
        setContentView(R.layout.main); 
         
        this.mAIntent = new Intent(this,HomeActivity.class); 
        this.mBIntent = new Intent(this,HomeActivity.class); 
        this.mCIntent = new Intent(this,HomeActivity.class); 
        this.mDIntent = new Intent(this,HomeActivity.class); 
        this.mEIntent = new Intent(this,HomeActivity.class); 
         
        ((RadioButton) findViewById(R.id.radio_home)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.radio_square)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.radio_message)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.radio_friend)) 
        .setOnCheckedChangeListener(this); 
        ((RadioButton) findViewById(R.id.radio_more)) 
        .setOnCheckedChangeListener(this); 
         
        setupIntent(); 
    } 

    @Override 
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { 
        if(isChecked){ 
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
                this.mTabHost.setCurrentTabByTag("D_TAB"); 
                break; 
            case R.id.radio_more: 
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

        localTabHost.addTab(buildTabSpec("C_TAB", 
                R.string.main_messages, R.drawable.main_radio_message, 
                this.mCIntent)); 

        localTabHost.addTab(buildTabSpec("D_TAB", R.string.main_friends, 
                R.drawable.main_radio_friend, this.mDIntent)); 

        localTabHost.addTab(buildTabSpec("MORE_TAB", R.string.main_more, 
                R.drawable.main_radio_more, this.mEIntent)); 

    } 
     
  

	private TabHost.TabSpec buildTabSpec(String tag, int resLabel, int resIcon, 
            final Intent content) { 
        return this.mTabHost.newTabSpec(tag).setIndicator(getString(resLabel), 
                getResources().getDrawable(resIcon)).setContent(content); 
    } 
} 
