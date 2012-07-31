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
 * 界面换肤类，换肤相关方法都在这里实现
 * 
 * @author CYX
 * 
 */
public class SkinManager {
	private String mSkinNameString = "";
	Context mContext = null;
	Context mSkinContext = null;

	/**
	 * 初始化换肤类
	 * 
	 * @param packageNameString
	 *            用于换肤的皮肤包名
	 * @param windowActivity
	 *            换肤的活动
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
			CommonOperation.showShortToast("不存在改皮肤，请确认皮肤已安装。", context);
		}

	}

	/**
	 * 获取当前手机中所有的皮肤主题
	 * 
	 * @param context
	 *            上下文
	 * @return 皮肤数组
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
	 * 获取皮肤预览图
	 * 
	 * @return
	 */
	public Drawable getPreview() {
		Drawable previewDrawable = null;
		try {
			previewDrawable = mSkinContext.getResources().getDrawable(
					R.drawable.preview1);
		} catch (Exception e) {
			CommonOperation.showShortToast("该皮肤不存在预览图。错误信息"+e.getMessage(), mContext);
		}
		return previewDrawable;
	}

	/**
	 * 获取图片资源
	 * 
	 * @param id
	 *            资源ID
	 * @return
	 */
	public Drawable getDrawableResource(int id) {
		Drawable previewDrawable = mSkinContext.getResources().getDrawable(id);
		return previewDrawable;
	}

	/**
	 * 获取图片资源并且设置边界
	 * 
	 * @param id
	 *            资源ID
	 * @return 使用setBounds设置过的Drawable
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
	 * 查找资源Id
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
