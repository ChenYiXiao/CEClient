package cewedo.acts;

import cewedo.adapter.SkinItemAdapter;
import cewedo.skn.SkinManager;
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class SkinActivity extends Activity {

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.skin);
		GridView skinsGridView=(GridView)findViewById(R.id.gvNative);
		skinsGridView.setAdapter(new SkinItemAdapter(SkinManager.getAllNativeSkins(this), this));		
	}

	

}
