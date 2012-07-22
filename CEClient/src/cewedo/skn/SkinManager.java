package cewedo.skn;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class SkinManager {
	private String skinNameString="";
	Context context =null;
	public SkinManager(String packageNameString,Activity windowActivity) throws NameNotFoundException
	{
		this.skinNameString=packageNameString;
		this.context =windowActivity.createPackageContext(packageNameString,
						Context.CONTEXT_IGNORE_SECURITY);
	}
	
	
	
	/**��ȡƤ��Ԥ��ͼ
	 * @param id
	 * @return
	 */
	public Drawable getPreview(integer id)
	{
		Drawable previewDrawable = context.getResources().getDrawable(findResourceId("preview1"));
		return previewDrawable;
	}
	
	/**��ȡͼƬ��Դ
	 * @param id
	 * @return
	 */
	public Drawable getDrawableResource(int id) {
		Drawable previewDrawable = context.getResources().getDrawable(id);
		return previewDrawable;
	}
	
	/**������ԴId
	 * @param nameString
	 * @return
	 */
	private int findResourceId(String nameString) {
		Resources resources = context.getResources();
		int indentify = resources.getIdentifier(context.getPackageName()+":drawable/"+nameString, null, null);
		return indentify;
	}
}
