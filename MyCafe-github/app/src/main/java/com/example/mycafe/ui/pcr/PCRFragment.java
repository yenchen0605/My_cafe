package com.example.mycafe.ui.pcr;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycafe.R;
import com.example.mycafe.databinding.FragmentManagerBinding;
import com.example.mycafe.databinding.FragmentPCRBinding;
import com.example.mycafe.ui.pcr.PCRViewModel;

public class PCRFragment extends Fragment {

    private FragmentPCRBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PCRViewModel pcrViewModel =
                new ViewModelProvider(this).get(PCRViewModel.class);

        binding = FragmentPCRBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Toast.makeText(getContext(),"個人消費紀錄",Toast.LENGTH_LONG).show();
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}