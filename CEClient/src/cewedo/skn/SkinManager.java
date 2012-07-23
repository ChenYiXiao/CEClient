package cewedo.skn;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.R.style;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

/**���滻���࣬������ط�����������ʵ��
 * @author CYX
 *
 */
public class SkinManager {
	private String skinNameString = "";
	Context context = null;

	/**��ʼ��������
	 * @param packageNameString ���ڻ�����Ƥ������
	 * @param windowActivity �����Ļ
	 * @throws NameNotFoundException
	 */
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

	/**��ȡ��ǰ�ֻ������е�Ƥ������
	 * @param context ������
	 * @return Ƥ������
	 */
	public static List<SkinItem> getAllNativeSkins(Context context) {

		List<SkinItem> skinItems = new ArrayList<SkinItem>();
		List<PackageInfo> packs = context.getPackageManager()
				.getInstalledPackages(0);
		for (int i = 0; i < packs.size(); i++) {
			PackageInfo p = packs.get(i);
			String nameString = p.applicationInfo.loadLabel(
					context.getPackageManager()).toString();
			if (nameString == null)
				nameString = "";
			if (p.sharedUserId != null)
				if (p.sharedUserId.equals("cewedo.client")) {
					SkinItem skinItem = new SkinItem();
					skinItem.setNameString(nameString);
					skinItem.setPackageString(p.applicationInfo.packageName);
					SkinManager skinManager;
					try {
						skinManager = new SkinManager(
								skinItem.getPackageString(), (Activity) context);
						skinItem.setPreviewDrawable(skinManager.getPreview());
					} catch (NameNotFoundException e) {
						e.printStackTrace();
					}
					skinItems.add(skinItem);
				}
		}
		return skinItems;
	}

	/**
	 * ��ȡƤ��Ԥ��ͼ
	 * 
	 * @return
	 */
	public Drawable getPreview() {
		Drawable previewDrawable = context.getResources().getDrawable(
				findResourceId("preview1"));
		return previewDrawable;
	}

	/**
	 * ��ȡͼƬ��Դ
	 * 
	 * @param id ��ԴID
	 * @return
	 */
	public Drawable getDrawableResource(int id) {
		Drawable previewDrawable = context.getResources().getDrawable(id);
		return previewDrawable;
	}

	/**
	 * ��ȡͼƬ��Դ�������ñ߽�
	 * 
	 * @param id ��ԴID
	 * @return ʹ��setBounds���ù���Drawable
	 */
	public Drawable getRectDrawableResource(int id) {
		Drawable previewDrawable = context.getResources().getDrawable(id);
		previewDrawable.setBounds(0, 0, previewDrawable.getIntrinsicWidth(),
				previewDrawable.getIntrinsicHeight());
		return previewDrawable;
	}

	/**
	 * @param id
	 * @return
	 */
	public TypedArray getStyleResource(int id) {
		TypedArray styleArray = context.getResources().obtainTypedArray(id);
		return styleArray;
	}

	/**
	 * ������ԴId
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
