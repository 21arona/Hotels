package com.example.tpallfootball.entities;

import android.database.Cursor;

public class Competition {
    public int id_competition;
    public String nom;

    public Competition() {
    }

    public Competition(String nom) {
        this.nom = nom;
    }

    public Competition(Cursor cursor) {
        this.id_competition = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.nom = cursor.getString(cursor.getColumnIndexOrThrow("competition_nom"));
    }

    public int getId_competition() {
        return id_competition;
    }

    public void setId_competition(int id_competition) {
        this.id_competition = id_competition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}