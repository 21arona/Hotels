package com.example.tpallfootball.entities;

import android.database.Cursor;

public class Match {
    public enum Statut {
        TERMINÉ, EN_COURS, À_VENIR
    }
    public int id_match;
    public String statut;
    public String nomEquipeDomicile;
    public String nomEquipeExterieure;
    public int scoreDomicile;
    public int scoreExterieur;
    public String nomCompetition;
    public Match() {

    }

    public Match(String statut, String nomEquipeDomicile, String nomEquipeExterieure, int scoreDomicile, int scoreExterieur, String nomCompetition) {
        this.statut = statut;
        this.nomEquipeDomicile = nomEquipeDomicile;
        this.nomEquipeExterieure = nomEquipeExterieure;
        this.scoreDomicile = scoreDomicile;
        this.scoreExterieur = scoreExterieur;
        this.nomCompetition = nomCompetition;
    }
    public Match(Cursor cursor){
        this.id_match = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.statut = cursor.getString(cursor.getColumnIndexOrThrow("statut"));
        this.nomEquipeDomicile = cursor.getString(cursor.getColumnIndexOrThrow("equipe_domicile_nom"));
        this.nomEquipeExterieure = cursor.getString(cursor.getColumnIndexOrThrow("equipe_exterieure_nom"));
        this.scoreDomicile = cursor.getInt(cursor.getColumnIndexOrThrow("score_domicile"));
        this.scoreExterieur = cursor.getInt(cursor.getColumnIndexOrThrow("score_exterieure"));
        this.nomCompetition = cursor.getString(cursor.getColumnIndexOrThrow("competition_nom"));
    }

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getNomEquipeDomicile() {
        return nomEquipeDomicile;
    }

    public void setNomEquipeDomicile(String nomEquipeDomicile) {
        this.nomEquipeDomicile = nomEquipeDomicile;
    }

    public String getNomEquipeExterieure() {
        return nomEquipeExterieure;
    }

    public void setNomEquipeExterieure(String nomEquipeExterieure) {
        this.nomEquipeExterieure = nomEquipeExterieure;
    }

    public int getScoreDomicile() {
        return scoreDomicile;
    }

    public void setScoreDomicile(int scoreDomicile) {
        this.scoreDomicile = scoreDomicile;
    }

    public int getScoreExterieur() {
        return scoreExterieur;
    }

    public void setScoreExterieur(int scoreExterieur) {
        this.scoreExterieur = scoreExterieur;
    }

    public String getNomCompetition() {
        return nomCompetition;
    }

    public void setNomCompetition(String nomCompetition) {
        this.nomCompetition = nomCompetition;
    }

//    @Override
//    public String toString() {
//        return "Match: [ID=" + nomCompetition + ", Equipe1=" + nomEquipeDomicile + ", score Dom=" + scoreDomicile + ", score Ext=" + scoreExterieur + ", Equipe2=" + nomEquipeExterieure + "]";
//    }
}
