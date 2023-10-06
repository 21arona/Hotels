package com.example.tpallfootball.entities;

import android.database.Cursor;

public class Joueur {
    public int id_joueur;

    public String nom;

    public String poste;

    public int numero;

    public String nomEquipe;

    public Joueur() {

    }

    public Joueur(String nom, String poste, int numero, String nomEquipe) {
        this.id_joueur = id_joueur;
        this.nom = nom;
        this.poste = poste;
        this.numero = numero;
        this.nomEquipe = nomEquipe;
    }

    public Joueur(Cursor cursor) {
        this.id_joueur = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
        this.nom = cursor.getString(cursor.getColumnIndexOrThrow("joueur_nom"));
        this.poste = cursor.getString(cursor.getColumnIndexOrThrow("joueur_poste"));
        this.numero = cursor.getInt(cursor.getColumnIndexOrThrow("joueur_numero"));
        this.nomEquipe = cursor.getString(cursor.getColumnIndexOrThrow("joueur_equipe"));
    }

    public Joueur(int id, String nom, String poste, int numero, String nomEquipe) {

    }

    public int getId_joueur() {
        return id_joueur;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }
}
