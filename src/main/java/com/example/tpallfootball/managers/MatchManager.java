package com.example.tpallfootball.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tpallfootball.entities.Match;
import com.example.tpallfootball.services.ConnexionBd;

import java.util.ArrayList;

public class MatchManager {

    public static ArrayList<Match> getAllMatchs(Context context){
        ArrayList<Match> retour = null;
        SQLiteDatabase bd = ConnexionBd.getBd(context);
        Cursor cursor = bd.rawQuery("SELECT * FROM matchs", null);

        if (cursor.isBeforeFirst()) {
            retour = new ArrayList<>();
            while (cursor.moveToNext()) {
                retour.add(new Match(cursor));
            }
        }
        return retour;

    }
}