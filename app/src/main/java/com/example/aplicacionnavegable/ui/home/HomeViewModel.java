package com.example.aplicacionnavegable.ui.home;

import android.app.Application;
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

public class HomeViewModel extends AndroidViewModel{
    private static final String DB_NAME = "nota";
    private final MutableLiveData<List<Nota>> lista;
    private Context context;


    public HomeViewModel(@NonNull Application application) {
        super(application);
        lista = new MutableLiveData<>();
        context= application.getApplicationContext();

    }

    public LiveData<List<Nota>> getList() {
        return lista;
    }
    public void setLista(){
        SqLiteHelper mySQLiteHelper = new SqLiteHelper(context);
        SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();
        List<Nota> listaNew = new ArrayList();
        if(db!=null){
            Cursor c = db.query(
                    DB_NAME,  // Nombre de la tabla
                    null,  // Lista de Columnas a consultar
                    null,  // Columnas para la cláusula WHERE
                    null,  // Valores a comparar con las columnas del WHERE
                    null,  // Agrupar con GROUP BY
                    null,  // Condición HAVING para GROUP BY
                    null  // Cláusula ORDER BY
            );
            while(c.moveToNext()){
                listaNew.add(new Nota(c.getInt(0),c.getString(1),c.getString(2)));
            }
        }
        lista.setValue(listaNew);
    }
}