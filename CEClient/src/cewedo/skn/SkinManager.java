package cewedo.skn;

import android.R.integer;
import android.R.style;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

public class SkinManager {
	private String skinNameString = "";
	Context context = null;

	public SkinManager(String packageNameString, Activity windowActivity)
			throws NameNotFoundException {
		this.skinNameString = packageNameString;
		if (skinNameString == "default") {
			this.context = windowActivity;
		} else {
			this.context = windowActivity.createPackageContext(
					packageNameString, Context.CONTEXT_IGNORE_SECURITY);
		}
	}

	/**
	 * 获取皮肤预览图
	 * 
	 * @param id
	 * @return
	 */
	public Drawable getPreview(integer id) {
		Drawable previewDrawable = context.getResources().getDrawable(
				findResourceId("preview1"));
		return previewDrawable;
	}

	/**
	 * 获取图片资源
	 * 
	 * @param id
	 * @return
	 */
	public Drawable getDrawableResource(int id) {
		Drawable previewDrawable = context.getResources().getDrawable(id);
		return previewDrawable;
	}

	/**
	 * 获取图片资源并且设置边界
	 * 
	 * @param id
	 * @return
	 */
	public Drawable getRectDrawableResource(int id) {
		Drawable previewDrawable = context.getResources().getDrawable(id);
		previewDrawable.setBounds(0, 0, previewDrawable.getIntrinsicWidth(),
				previewDrawable.getIntrinsicHeight());
		return previewDrawable;
	}

	public TypedArray getStyleResource(int id) {
		TypedArray styleArray = context.getResources().obtainTypedArray(id);
		return styleArray;
	}

	/**
	 * 查找资源Id
	 * 
	 * @param nameString
	 * @return
	 */
	private int findResourceId(String nameString) {
		Resources resources = context.getResources();
		int indentify = resources.getIdentifier(context.getPackageName()
				+ ":drawable/" + nameString, null, null);
		return indentify;
	}
}
