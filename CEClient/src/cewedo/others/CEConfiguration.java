package cewedo.others;

import cewedo.skn.SkinItem;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * @author CYX
 *全局设置类
 */
public class CEConfiguration {
	
		/**获取皮肤名称
		 * @param context
		 * @return
		 */
		public static String getSkinName(Context context)
		{
			SharedPreferences preferences;
			preferences=PreferenceManager.getDefaultSharedPreferences(context);
			
			
			return preferences.getString("skinName", "Default");
		}
		public static String getSkinPackageName(Context context)
		{
			SharedPreferences preferences;
			preferences=PreferenceManager.getDefaultSharedPreferences(context);
			return preferences.getString("skinPackageName", "cewedo.acts");
		}
		/**设置皮肤
		 * @param context
		 * @param skinItem 皮肤
		 */
		public static void setSkinName(Context context,String skinName)
		{
			SharedPreferences preferences;
			SharedPreferences.Editor editor;
			preferences=PreferenceManager.getDefaultSharedPreferences(context);
			editor=preferences.edit();
			editor.putString("skinName", skinName);
			editor.commit();
		}
		public static void setSkinPackageName(Context context,String skinPackageName)
		{
			SharedPreferences preferences;
			SharedPreferences.Editor editor;
			preferences=PreferenceManager.getDefaultSharedPreferences(context);
			editor=preferences.edit();
			editor.putString("skinPackageName", skinPackageName);
			editor.commit();
		}
}
