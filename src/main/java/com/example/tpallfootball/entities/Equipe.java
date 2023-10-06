package com.example.tpallfootball.entities;

import android.database.Cursor;

public class Equipe {
    public int id_equipe;
    public int position_classement;
    public String nomEquipe;
    public String nomCompetition;

    public Equipe() {
    }

    public Equipe(String nom_equipe, String nomCompetition, int position_classement) {
        this.nomEquipe = nom_equipe;
        this.nomCompetition = nomCompetition;
        this.position_classement = position_classement;
    }

    public Equipe(Cursor cursor) {
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public int getPosition_classement() {
        return position_classement;
    }

    public void setPosition_classement(int position_classement) {
        this.position_classement = position_classement;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }
}
