package edu.psu.jjb24.csjokes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class DisplayPunchlineDialog extends DialogFragment {

    PunchLineDialogListener listener;
    public interface PunchLineDialogListener {
        void displaySetupDialog(String title, String setup, String punchline);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (PunchLineDialogListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            String title = getArguments().getString("title");
            String punchline = getArguments().getString("punchline");
            builder.setTitle(title)
                .setMessage(getArguments().getString("setup"))

                .setPositiveButton("PUNCHLINE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.displaySetupDialog(getArguments().getString("title"),
                                getArguments().getString("setup"), getArguments().getString("punchline"));
                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                return builder.create();


    }
}