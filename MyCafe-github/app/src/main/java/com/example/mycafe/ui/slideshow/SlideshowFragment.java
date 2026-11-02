package com.example.mycafe.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mycafe.R;
import com.example.mycafe.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textSlideshow;
        //slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        binding.menuSpinner.setOnItemSelectedListener(menuSpinnerSelected);//監聽
        Toast.makeText(getContext(),"MENU", Toast.LENGTH_SHORT).show();
        return root;
    }

    private final AdapterView.OnItemSelectedListener menuSpinnerSelected =new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch(position) {
                case 0:
                    Toast.makeText(getContext(),"新品上市！", Toast.LENGTH_SHORT).show();;
                    binding.menuPic.setImageResource(R.drawable.c3);
                     break;
                case 1:
                    Toast.makeText(getContext(),"黑糖咖啡", Toast.LENGTH_SHORT).show();;;
                    binding.menuPic.setImageResource(R.drawable.c2); break;
                case 2:
                    Toast.makeText(getContext(),"真好喝紅茶！", Toast.LENGTH_SHORT).show();;;
                    binding.menuPic.setImageResource(R.drawable.c5); break;
                case 3:
                    Toast.makeText(getContext(),"純鮮奶奶茶！", Toast.LENGTH_SHORT).show();;;
                    binding.menuPic.setImageResource(R.drawable.c4); break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
