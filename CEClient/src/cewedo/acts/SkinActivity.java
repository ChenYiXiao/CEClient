package cewedo.acts;

import cewedo.adapter.SkinItemAdapter;
import cewedo.others.CEConfiguration;
import cewedo.skn.SkinItem;
import cewedo.skn.SkinManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**换肤活动
 * @author Administrator
 *
 */
public class SkinActivity extends BaseActivity {
	private ImageButton mBackImageButton=null;
	private RadioGroup mMainRadioGroup=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skin);
		final GridView skinsGridView=(GridView)findViewById(R.id.gvNative);
		skinsGridView.setAdapter(new SkinItemAdapter(SkinManager.getAllNativeSkins(this), this));		
		skinsGridView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				SkinItem skinItem=(SkinItem) skinsGridView.getAdapter().getItem(arg2);
				CEConfiguration.setSkinName(SkinActivity.this, skinItem.getNameString());
				CEConfiguration.setSkinPackageName(SkinActivity.this, skinItem.getPackageString());
				
				SkinManager.updateActsSkin();
				Toast.makeText(SkinActivity.this, "当前皮肤已经切换成 "+CEConfiguration.getSkinName(SkinActivity.this)
						, 2000).show();
			}
		});
		mBackImageButton=(ImageButton)findViewById(R.id.ibBack);
		mMainRadioGroup=(RadioGroup)findViewById(R.id.main_radio);
		mBackImageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		ChangeSkin();
	}

	/* (non-Javadoc)
	 * @see cewedo.acts.BaseActivity#ChangeSkin()
	 */
	@Override
	public void ChangeSkin() {
		SkinManager skinManager=new SkinManager(CEConfiguration.getSkinPackageName(this), this);
		mBackImageButton.setImageDrawable(skinManager.getDrawableResource(R.drawable.btn_back));
		mMainRadioGroup.setBackgroundDrawable(skinManager.getDrawableResource(R.drawable.home_bg_top));
		super.ChangeSkin();
	}
	

	

}
