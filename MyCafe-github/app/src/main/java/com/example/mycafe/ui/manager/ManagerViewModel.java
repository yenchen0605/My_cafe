package com.example.mycafe.ui.manager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ManagerViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ManagerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is value fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}