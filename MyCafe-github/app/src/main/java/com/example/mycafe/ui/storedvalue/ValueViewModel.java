package com.example.mycafe.ui.storedvalue;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ValueViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ValueViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("我的會員卡");
    }

    public LiveData<String> getText() {
        return mText;
    }
}