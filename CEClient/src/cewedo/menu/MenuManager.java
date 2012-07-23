package cewedo.menu;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import cewedo.acts.R;
import cewedo.acts.SkinActivity;
import cewedo.acts.R.menu;

public class MenuManager {
	public static void  getMenu(Menu menu,int id,Activity activity) {
		MenuInflater inflater = new MenuInflater(activity);
		inflater.inflate(id, menu);
	}
	public static void doMenuSelect(int featureId, MenuItem item ,Activity activity)
	{
		switch (item.getItemId()) {
		case R.id.menuSkinManager:
			activity.startActivity(new Intent(activity,SkinActivity.class));
			break;

		default:
			break;
		}
	}
}
