package cewedo.skn;

import java.util.ArrayList;
import java.util.List;

import cewedo.acts.R;
import cewedo.others.CommonOperation;

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

/**
 * ���滻���࣬������ط�����������ʵ��
 * 
 * @author CYX
 * 
 */
public class SkinManager {
	private String mSkinNameString = "";
	Context mContext = null;
	Context mSkinContext = null;

	/**
	 * ��ʼ��������
	 * 
	 * @param packageNameString
	 *            ���ڻ�����Ƥ������
	 * @param windowActivity
	 *            �����Ļ
	 * @throws NameNotFoundException
	 */
	public SkinManager(String packageNameString, Context context) {
		this.mSkinNameString = packageNameString;
		mContext = context;
		try {
			if (packageNameString.equals("default")) {
				this.mSkinContext = context;
			} else {
				this.mSkinContext = context.createPackageContext(
						packageNameString, Context.CONTEXT_IGNORE_SECURITY);
			}
		} catch (NameNotFoundException e) {
			CommonOperation.showShortToast("�����ڸ�Ƥ������ȷ��Ƥ���Ѱ�װ��", context);
		}

	}

	/**
	 * ��ȡ��ǰ�ֻ������е�Ƥ������
	 * 
	 * @param context
	 *            ������
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
					skinManager = new SkinManager(skinItem.getPackageString(),
							context);
					skinItem.setPreviewDrawable(skinManager.getPreview());
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
		Drawable previewDrawable = null;
		try {
			previewDrawable = mSkinContext.getResources().getDrawable(
					R.drawable.preview1);
		} catch (Exception e) {
			CommonOperation.showShortToast("��Ƥ��������Ԥ��ͼ��������Ϣ"+e.getMessage(), mContext);
		}
		return previewDrawable;
	}

	/**
	 * ��ȡͼƬ��Դ
	 * 
	 * @param id
	 *            ��ԴID
	 * @return
	 */
	public Drawable getDrawableResource(int id) {
		Drawable previewDrawable = mSkinContext.getResources().getDrawable(id);
		return previewDrawable;
	}

	/**
	 * ��ȡͼƬ��Դ�������ñ߽�
	 * 
	 * @param id
	 *            ��ԴID
	 * @return ʹ��setBounds���ù���Drawable
	 */
	public Drawable getRectDrawableResource(int id) {
		Drawable previewDrawable = mSkinContext.getResources().getDrawable(id);
		previewDrawable.setBounds(0, 0, previewDrawable.getIntrinsicWidth(),
				previewDrawable.getIntrinsicHeight());
		return previewDrawable;
	}

	/**
	 * @param id
	 * @return
	 */
	public TypedArray getStyleResource(int id) {
		TypedArray styleArray = mSkinContext.getResources()
				.obtainTypedArray(id);
		return styleArray;
	}

	/**
	 * ������ԴId
	 * 
	 * @param nameString
	 * @return
	 */
	private int findResourceId(String nameString) {
		Resources resources = mSkinContext.getResources();
		int indentify = resources.getIdentifier(mContext.getPackageName()
				+ ":drawable/" + nameString, null, null);
		return indentify;
	}
}
