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
		builder.setTitle("ȷ��");
		builder.setMessage("ȷ���˳���");
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				System.exit(0);
			}
		});
		builder.setNegativeButton("ȡ��", null);
		builder.create().show();

	}
}
