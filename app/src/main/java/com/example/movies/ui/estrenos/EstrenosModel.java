package com.example.movies.ui.estrenos;


import android.widget.ListView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EstrenosModel extends ViewModel {

    private MutableLiveData<String> mText;

    public EstrenosModel() {


    }

    public LiveData<String> getText() {

        return mText;
    }
}