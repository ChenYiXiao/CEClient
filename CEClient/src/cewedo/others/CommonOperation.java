package cewedo.others;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

public class CommonOperation {
	public static void showShortToast(String text,Context context)
	{
		Toast.makeText(context, text, 2000).show();
	}
	public static void showExitDialog(Context context) {
		final Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("确认");
		builder.setMessage("确定退出？");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				System.exit(0);
			}
		});
		builder.setNegativeButton("取消", null);
		builder.create().show();

	}
}
