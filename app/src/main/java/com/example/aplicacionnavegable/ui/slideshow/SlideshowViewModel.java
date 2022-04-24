package com.example.aplicacionnavegable.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SlideshowViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<String> nombreMutable;

    public SlideshowViewModel() {
        mText = new MutableLiveData<>();
        nombreMutable= new MutableLiveData<>();
      //  mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getnombreMutable() {
        return nombreMutable;
    }
    public void setNombreMutable(String nombre){
        if(nombre=="") {
            nombreMutable.setValue(nombre);
        }else {
            nombreMutable.setValue("Esta vacio");
        }

    }
}