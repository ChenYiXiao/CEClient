package cewedo.acts;

import cewedo.adapter.SkinItemAdapter;
import cewedo.others.CEConfiguration;
import cewedo.others.Global;
import cewedo.skn.SkinChangeable;
import cewedo.skn.SkinItem;
import cewedo.skn.SkinManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SkinActivity extends BaseActivity {
	private ImageButton ibBack=null;
	private RadioGroup mainGroup=null;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
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
		ibBack=(ImageButton)findViewById(R.id.ibBack);
		mainGroup=(RadioGroup)findViewById(R.id.main_radio);
		ibBack.setOnClickListener(new OnClickListener() {

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
		ibBack.setImageDrawable(skinManager.getDrawableResource(R.drawable.btn_back));
		mainGroup.setBackgroundDrawable(skinManager.getDrawableResource(R.drawable.home_bg_top));
		super.ChangeSkin();
	}
	

	

}
