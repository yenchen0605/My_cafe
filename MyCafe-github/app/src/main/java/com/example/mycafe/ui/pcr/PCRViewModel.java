package com.example.mycafe.ui.pcr;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PCRViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public PCRViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is value fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}