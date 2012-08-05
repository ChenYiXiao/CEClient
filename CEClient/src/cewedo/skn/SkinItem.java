package cewedo.skn;

import android.graphics.drawable.Drawable;

/**皮肤项实体类
 * @author CYX
 *
 */
public class SkinItem {
	private String nameString="";
	private String packageString="";
	private Drawable previewDrawable=null;
	/**
	 * @return the nameString
	 */
	public String getNameString() {
		return nameString;
	}
	/**
	 * @param nameString the nameString to set
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	/**
	 * @return the packageString
	 */
	public String getPackageString() {
		return packageString;
	}
	/**
	 * @param packageString the packageString to set
	 */
	public void setPackageString(String packageString) {
		this.packageString = packageString;
	}
	/**
	 * @return the previewDrawable
	 */
	public Drawable getPreviewDrawable() {
		return previewDrawable;
	}
	/**
	 * @param previewDrawable the previewDrawable to set
	 */
	public void setPreviewDrawable(Drawable previewDrawable) {
		this.previewDrawable = previewDrawable;
	}
	
}
