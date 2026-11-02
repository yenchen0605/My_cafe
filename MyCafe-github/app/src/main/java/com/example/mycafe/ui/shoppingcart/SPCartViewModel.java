package com.example.mycafe.ui.shoppingcart;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SPCartViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public SPCartViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is SPC fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }}