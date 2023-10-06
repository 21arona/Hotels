package com.example.tpallfootball.entities;

import android.database.Cursor;

public class Classement {
    public int idClassement;

    public String nomCompetition;

    public String nomEquipe;

    public int nbPoints;

    public int getMatchs_joues() {
        return matchs_joues;
    }

    public void setMatchs_joues(int matchs_joues) {
        this.matchs_joues = matchs_joues;
    }

    public int matchs_joues;

    public int nb_victoires;

    public int nb_defaites;


    public int getNb_victoires() {
        return nb_victoires;
    }

    public void setNb_victoires(int nb_victoires) {
        this.nb_victoires = nb_victoires;
    }

    public int getNb_defaites() {
        return nb_defaites;
    }

    public void setNb_defaites(int nb_defaites) {
        this.nb_defaites = nb_defaites;
    }


    public Classement() {
    }

    public Classement(String nomCompetition, String nomEquipe, int nbPoints, int match_joues) {
        this.nomCompetition = nomCompetition;
        this.nomEquipe = nomEquipe;
        this.nbPoints = nbPoints;
        this.matchs_joues = match_joues;
    }

    public int getIdClassement() {
        return idClassement;
    }

    public void setIdClassement(int idClassement) {
        this.idClassement = idClassement;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    public int getPositionEquipe() {
        return matchs_joues;
    }

    public void setPositionEquipe(int positionEquipe) {
        this.matchs_joues = positionEquipe;
    }

    public Classement(Cursor cursor) {
        this.idClassement = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.nomCompetition = cursor.getString(cursor.getColumnIndexOrThrow("competition_nom"));
        this.nomEquipe = cursor.getString(cursor.getColumnIndexOrThrow("equipe_nom"));
        this.matchs_joues  = cursor.getInt(cursor.getColumnIndexOrThrow("matchs_joues"));
        this.nbPoints = cursor.getInt(cursor.getColumnIndexOrThrow("nb_points"));
        this.nb_victoires = cursor.getInt(cursor.getColumnIndexOrThrow("nb_victoires"));
        this.nb_defaites = cursor.getInt(cursor.getColumnIndexOrThrow("nb_defaites"));
    }

}
