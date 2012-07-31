package cewedo.others;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class Global {
	private static String SkinName="";
	private static String SkinPackageName="" ;	
	private static List<Activity> CurrentAcitivities=new ArrayList<Activity>();
	/**
	 * @return the skinName
	 */
	public static String getSkinName() {
		return SkinName;
	}
	/**
	 * @param skinName the skinName to set
	 */
	public static void setSkinName(String skinName) {
		SkinName = skinName;
	}
	/**
	 * @return the skinPackageName
	 */
	public static String getSkinPackageName() {
		return SkinPackageName;
	}
	/**
	 * @param skinPackageName the skinPackageName to set
	 */
	public static void setSkinPackageName(String skinPackageName) {
		SkinPackageName = skinPackageName;
	}
	/**
	 * @return the currentAcitivities
	 */
	public static List<Activity> getCurrentAcitivities() {
		return CurrentAcitivities;
	}
	/**
	 * @param currentAcitivities the currentAcitivities to set
	 */
	public static void setCurrentAcitivities(List<Activity> currentAcitivities) {
		CurrentAcitivities = currentAcitivities;
	}
}
