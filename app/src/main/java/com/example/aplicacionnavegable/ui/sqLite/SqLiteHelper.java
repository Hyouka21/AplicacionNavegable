package com.example.aplicacionnavegable.ui.sqLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqLiteHelper extends SQLiteOpenHelper {
    private static final String NOTA_TABLE_CREATE = "CREATE TABLE nota(_id INTEGER PRIMARY KEY AUTOINCREMENT, titulo TEXT, cuerpo TEXT)";
    private static final String DB_NAME = "nota.sqlite";
    private static final int DB_VERSION = 1;

    public SqLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(NOTA_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
