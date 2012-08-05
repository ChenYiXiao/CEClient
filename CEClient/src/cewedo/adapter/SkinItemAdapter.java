package cewedo.adapter;

import cewedo.acts.*;
import java.util.List;

import cewedo.skn.SkinItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**Ƥ���˵����������
 * @author CYX
 *
 */
public class SkinItemAdapter extends BaseAdapter {
	private List<SkinItem> mSkinsSkinItems = null;
	private Context mContext = null;

	public SkinItemAdapter(List<SkinItem> skinsSkinItems, Context context) {
		this.mContext = context;
		this.mSkinsSkinItems = skinsSkinItems;
	}

	@Override
	public int getCount() {
		return mSkinsSkinItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		return mSkinsSkinItems.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int positon, View convertView, ViewGroup parent) {
		String inflaterString = Context.LAYOUT_INFLATER_SERVICE;
		SkinItem currentSkinItem = mSkinsSkinItems.get(positon);

		LayoutInflater layoutInflater = (LayoutInflater) mContext
				.getSystemService(inflaterString);
		// �õ�Item�����Բ���
		LinearLayout skinItemLayout = null;
		skinItemLayout = (LinearLayout) layoutInflater.inflate(
				R.layout.itemskin, null);
		// ����ͼƬ
		ImageView imageView = (ImageView) skinItemLayout
				.findViewById(R.id.imgPreview);
		imageView.setImageDrawable(currentSkinItem.getPreviewDrawable());
		// �����ı�
		TextView skinNameTextView = (TextView) skinItemLayout
				.findViewById(R.id.tvSkinName);
		skinNameTextView.setText(currentSkinItem.getNameString());

		// ��������
		
		return skinItemLayout;

	}

}
