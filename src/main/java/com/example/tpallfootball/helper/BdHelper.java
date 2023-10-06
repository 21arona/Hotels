package com.example.tpallfootball.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class BdHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bdAllFootball.db";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    public BdHelper(Context myContext) {
        super(myContext, DATABASE_NAME, null, DATABASE_VERSION);
        context = myContext;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //onCreate sera appelée si la base de données n'existe pas encore
        // pas besoin d'insert ici on a deja les donnees
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // onUpgrade sera appelée si la version de la base de données change
        // écrire ici le code pour mettre à jour vos tables si nécessaire
    }

    public static void copyDatabaseFromAssets(Context context){
        if (!isDataBase(context)) {
            try {
                int bufferSize = 256;
                OutputStream out = new FileOutputStream(context.getDatabasePath(DATABASE_NAME));
                InputStream in = context.getAssets().open( DATABASE_NAME);
                byte[] buffer = new byte[bufferSize];
                while (in.read(buffer) != -1) {
                    out.write(buffer);
                    buffer = new byte[bufferSize];
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isDataBase(Context context){
        return context.getDatabasePath(DATABASE_NAME).exists();
    }
}
