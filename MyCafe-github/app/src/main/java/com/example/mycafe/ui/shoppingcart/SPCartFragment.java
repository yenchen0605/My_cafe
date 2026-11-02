package com.example.mycafe.ui.shoppingcart;

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
import com.example.mycafe.databinding.FragmentHomeBinding;
import com.example.mycafe.databinding.FragmentSPCartBinding;
import com.example.mycafe.ui.home.HomeViewModel;

public class SPCartFragment extends Fragment {

    //private FragmentSPCartBinding binding;
    private FragmentSPCartBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SPCartViewModel spCartViewModel =
                new ViewModelProvider(this).get(SPCartViewModel.class);

        binding = FragmentSPCartBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Toast.makeText(getContext(),"購物車",Toast.LENGTH_LONG).show();
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}