package com.example.mycafe.ui.storedvalue;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycafe.R;
import com.example.mycafe.ValueDialogFragment;
import com.example.mycafe.databinding.FragmentHomeBinding;
import com.example.mycafe.databinding.FragmentValueBinding;
import com.example.mycafe.ui.home.HomeViewModel;

public class ValueFragment extends Fragment  {

    private FragmentValueBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ValueViewModel valueViewModel =
                new ViewModelProvider(this).get(ValueViewModel.class);

        binding = FragmentValueBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final TextView textView = binding.textValue;
        valueViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        Toast.makeText(getContext(),"會員卡/儲值",Toast.LENGTH_LONG).show();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }





}