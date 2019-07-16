package com.jsfarley.forecast;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public class AlertDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Context context = getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		//creates detailed dialog message
		builder.setTitle(R.string.error_title)
				.setMessage(R.string.error_message_body)
				.setPositiveButton(R.string.error_button_text, null);

		return builder.create();
	}

}

