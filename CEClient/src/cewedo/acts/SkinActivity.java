package cewedo.acts;

import cewedo.adapter.SkinItemAdapter;
import cewedo.others.CEConfiguration;
import cewedo.skn.SkinItem;
import cewedo.skn.SkinManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class SkinActivity extends Activity {

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
				Toast.makeText(SkinActivity.this, "当前皮肤已经切换成 "+CEConfiguration.getSkinName(SkinActivity.this)
				, 2000).show();
			}
		});
		
		
	}

	

}
