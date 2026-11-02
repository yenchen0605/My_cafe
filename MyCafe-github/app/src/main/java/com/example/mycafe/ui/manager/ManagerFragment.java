package com.example.mycafe.ui.manager;

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
import com.example.mycafe.databinding.FragmentValueBinding;
import com.example.mycafe.ui.manager.ManagerViewModel;

public class ManagerFragment extends Fragment {

    private FragmentManagerBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ManagerViewModel managerViewModel =
                new ViewModelProvider(this).get(ManagerViewModel.class);

        binding = FragmentManagerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Toast.makeText(getContext(),"會員資訊",Toast.LENGTH_LONG).show();
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}