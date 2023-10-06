package com.example.tpallfootball.services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.tpallfootball.helper.BdHelper;

import java.io.IOException;

public class ConnexionBd {

    private static final String DATABASE_NAME = "bdAllFootball.db";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteDatabase bd = null;
    private static BdHelper helper;

    public static SQLiteDatabase getBd(Context context) {
        if (helper == null) {
            helper = new BdHelper(context);
        }
        bd = helper.getWritableDatabase();
        return bd;
    }
    public static void close() {
        if (bd != null && !bd.isOpen()) {
            bd.close();
        }
    }
}
