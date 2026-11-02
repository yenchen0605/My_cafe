package com.example.mycafe;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class EnterFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());// Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        //setPositiveButton()右邊按鈕
        //setNegativeButton()中間按鈕
        //setNeutralButton()左邊按鈕
        builder.setView(inflater.inflate(R.layout.fragment_enter, null))
                // Add action buttons
                .setPositiveButton(R.string.bt_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {// sign in the user ...
                        Toast.makeText(getActivity(), "OK ", Toast.LENGTH_LONG).show();
                    }
                })
                .setNeutralButton(R.string.bt_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EnterFragment.this.getDialog().cancel();
                        Toast.makeText(getActivity(), "Cancel! ", Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.bt_clear, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {// User clicked OK button
                        Toast.makeText(getActivity(), "Clear!", Toast.LENGTH_LONG).show();
                    }
                });






        return builder.create();
    }

}