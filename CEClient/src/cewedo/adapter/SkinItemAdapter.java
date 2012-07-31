package cewedo.adapter;

import cewedo.acts.*;
import java.util.List;

import cewedo.skn.SkinItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SkinItemAdapter extends BaseAdapter {
	private List<SkinItem> skinsSkinItems = null;
	private Context context = null;

	public SkinItemAdapter(List<SkinItem> skinsSkinItems, Context context) {
		this.context = context;
		this.skinsSkinItems = skinsSkinItems;
	}

	@Override
	public int getCount() {
		return skinsSkinItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		return skinsSkinItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int positon, View convertView, ViewGroup parent) {
		String inflaterString = Context.LAYOUT_INFLATER_SERVICE;
		SkinItem currentSkinItem = skinsSkinItems.get(positon);

		LayoutInflater layoutInflater = (LayoutInflater) context
				.getSystemService(inflaterString);
		// 得到Item的线性布局
		LinearLayout skinItemLayout = null;
		skinItemLayout = (LinearLayout) layoutInflater.inflate(
				R.layout.itemskin, null);
		// 设置图片
		ImageView imageView = (ImageView) skinItemLayout
				.findViewById(R.id.imgPreview);
		imageView.setImageDrawable(currentSkinItem.getPreviewDrawable());
		// 设置文本
		TextView skinNameTextView = (TextView) skinItemLayout
				.findViewById(R.id.tvSkinName);
		skinNameTextView.setText(currentSkinItem.getNameString());

		// 长按监听
		
		return skinItemLayout;

	}

}
