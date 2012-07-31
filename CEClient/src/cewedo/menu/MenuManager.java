package cewedo.menu;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import cewedo.acts.R;
import cewedo.acts.SkinActivity;
import cewedo.acts.R.menu;
import cewedo.others.CommonOperation;
import cewedo.skn.SkinChangeable;
import cewedo.skn.SkinManager;

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
		case R.id.menuExit:
			CommonOperation.showExitDialog(activity);
			break;
		case R.id.menuNight:
			if(item.getTitle().equals(activity.getResources().getString(R.string.skinNight)))
			{
				
				SkinManager.setNightMode(activity);
				item.setTitle(activity.getResources().getString(R.string.skinDay));
				break;
			}
			else {
				SkinManager.setDayMode(activity);
				item.setTitle(activity.getResources().getString(R.string.skinNight));
				break;
			}		
		default:
			break;
		}
	}
}
