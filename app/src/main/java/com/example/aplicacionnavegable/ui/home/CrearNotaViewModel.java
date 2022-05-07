package com.example.aplicacionnavegable.ui.home;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
    private final MutableLiveData<Nota> notaE;
    private Context context;


    public CrearNotaViewModel(@NonNull Application application) {
        super(application);
        ok = new MutableLiveData<>();
        context= application.getApplicationContext();
        notaE =new MutableLiveData<>();
    }

    public LiveData<Boolean> getok() {
        if(ok==null){

        }
            return ok;
    }
    public LiveData<Nota> getnota() {
        return notaE;
    }
    public void crearNota(String titulo,String cuerpo){
        SqLiteHelper mySQLiteHelper = new SqLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

        if(db!=null){
            ContentValues cv = new ContentValues();
            cv.put("titulo", titulo);
            cv.put("cuerpo", cuerpo);
            db.insert(DB_NAME, null, cv);
            ok.setValue(true);
        }

    }
    public void guardarCambios(Nota nota) {
        SqLiteHelper mySQLiteHelper = new SqLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();
        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("titulo", nota.getTitulo());
        valoresParaActualizar.put("cuerpo", nota.getCuerpo());
        // where id...
        String campoParaActualizar = "_id = ?";
        // ... = idnota
        String[] argumentosParaActualizar = {String.valueOf(nota.getId())};
         int valor = db.update(DB_NAME, valoresParaActualizar, campoParaActualizar, argumentosParaActualizar);
         if(valor == 1){
             ok.setValue(true);
         }else{
             ok.setValue(false);
         }

    }

    public void editarNota (Bundle bundle){

        if(bundle !=null){
            Nota nota =(Nota) bundle.getSerializable("nota");
            notaE.setValue(nota);
        }
    }
}