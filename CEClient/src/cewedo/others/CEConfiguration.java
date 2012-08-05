package cewedo.others;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**ȫ�����ö�ȡ������
 * @author CYX
 *ȫ��������
 */
public class CEConfiguration {
	
		/**��ȡƤ������
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
		/**����Ƥ��
		 * @param context
		 * @param skinItem Ƥ��
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
