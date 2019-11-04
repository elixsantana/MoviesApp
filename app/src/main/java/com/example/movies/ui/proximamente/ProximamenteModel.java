package com.example.movies.ui.proximamente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProximamenteModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProximamenteModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}