package com.example.movies.ui.nuevosestrenos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NuevosEstrenosModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NuevosEstrenosModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}