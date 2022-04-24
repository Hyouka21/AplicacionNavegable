package com.example.aplicacionnavegable.ui.home;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aplicacionnavegable.ui.entidades.Nota;
import com.example.aplicacionnavegable.ui.sqLite.SqLiteHelper;

import java.util.ArrayList;
import java.util.List;

public class CrearNotaViewModel extends AndroidViewModel {
    private static final String DB_NAME = "nota";
    private final MutableLiveData<Boolean> ok;
    private Context context;


    public CrearNotaViewModel(@NonNull Application application) {
        super(application);
        ok = new MutableLiveData<>();
        context= application.getApplicationContext();

    }

    public LiveData<Boolean> getok() {
        return ok;
    }
    public void crearNota(String titulo,String cuerpo){
        SqLiteHelper mySQLiteHelper = new SqLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();
        Log.d("Excep!!!","aqui1");
        if(db!=null){
            Log.d("Excep!!!","aqui2");
            ContentValues cv = new ContentValues();
            cv.put("titulo", titulo);
            cv.put("cuerpo", cuerpo);
            db.insert(DB_NAME, null, cv);
            ok.setValue(true);
        }

    }
}