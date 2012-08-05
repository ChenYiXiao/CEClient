package cewedo.others;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**全局变量类，该类存放一些全局变量
 * @author CYX
 *
 */
public class Global {
	private static String mSkinName="";
	private static String mSkinPackageName="" ;	
	private static List<Activity> mCurrentAcitivities=new ArrayList<Activity>();
	/**
	 * @return the skinName
	 */
	public static String getSkinName() {
		return mSkinName;
	}
	/**
	 * @param skinName the skinName to set
	 */
	public static void setSkinName(String skinName) {
		mSkinName = skinName;
	}
	/**
	 * @return the skinPackageName
	 */
	public static String getSkinPackageName() {
		return mSkinPackageName;
	}
	/**
	 * @param skinPackageName the skinPackageName to set
	 */
	public static void setSkinPackageName(String skinPackageName) {
		mSkinPackageName = skinPackageName;
	}
	/**
	 * @return the currentAcitivities
	 */
	public static List<Activity> getCurrentAcitivities() {
		return mCurrentAcitivities;
	}
	/**
	 * @param currentAcitivities the currentAcitivities to set
	 */
	public static void setCurrentAcitivities(List<Activity> currentAcitivities) {
		mCurrentAcitivities = currentAcitivities;
	}
}
