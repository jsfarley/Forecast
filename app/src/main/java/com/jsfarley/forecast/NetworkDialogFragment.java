package com.jsfarley.forecast;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class NetworkDialogFragment extends DialogFragment {
	@Override
	public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

		Context context = getActivity();
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(R.string.network_dialog_title)
				.setMessage(R.string.network_dialog_message)
				.setPositiveButton(R.string.network_dialog_butn_text, null);

		return builder.create();
	}
}
