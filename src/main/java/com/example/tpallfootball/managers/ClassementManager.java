package com.example.tpallfootball.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tpallfootball.entities.Classement;
import com.example.tpallfootball.services.ConnexionBd;

import java.util.ArrayList;

public class ClassementManager {
    private static final String nomTbaleClassement = "classements";

    // Récupurer les donnees de la table classements
    private static ClassementManager instance = null;
    public static ClassementManager getInstance() {
        if (instance == null)
            instance = new ClassementManager();
        return instance;
    }


    public static ArrayList<Classement>getAll(Context context){
        SQLiteDatabase sqLiteDatabase = ConnexionBd.getBd(context);
        ArrayList<Classement> unClassement = null;
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM classements",null);
        if (cursor.isBeforeFirst()){
            unClassement = new ArrayList<>();
            while(cursor.moveToNext()){
                unClassement.add(new Classement(cursor));
            }
        }
        return  unClassement;
    }

    public static ArrayList<Classement> getByNameCompetition(Context context,String competition_name){
        SQLiteDatabase sqLiteDatabase = ConnexionBd.getBd(context);
        ArrayList<Classement>classements= null;
        String query = "SELECT * FROM classements where nom_competition = ?";
        Cursor cursor = sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(competition_name)});
        if (cursor.isBeforeFirst()){
            classements = new ArrayList<>();
            while(cursor.moveToNext()){
                classements.add(new Classement(cursor));
            }
        }

        return classements;
    }

    public static ArrayList<Classement> getByNbPoints(Context context ,int nb_points){
        SQLiteDatabase sqLiteDatabase = ConnexionBd.getBd(context);
        String query = "Select * from classements where nb_points > ?";
        Cursor cursor = sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(nb_points)});
        ArrayList<Classement>classements= null;

        if (cursor.isBeforeFirst()){
            classements = new ArrayList<>();
            while(cursor.moveToNext()){
                classements.add(new Classement(cursor));
            }
        }

        return classements;
    }
}
