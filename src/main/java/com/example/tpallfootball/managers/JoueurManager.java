package com.example.tpallfootball.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tpallfootball.entities.Joueur;
import com.example.tpallfootball.helper.BdHelper;

import java.util.ArrayList;
import java.util.List;

public class JoueurManager {

    private BdHelper bdHelper;

    public JoueurManager(Context context) {
        bdHelper = new BdHelper(context);
    }

    // Méthode pour récupérer les joueurs en fonction de l'équipe depuis la base de données
    public List<Joueur> getJoueursByEquipe(String nomEquipe) {
        List<Joueur> joueurs = new ArrayList<>();

        SQLiteDatabase db = bdHelper.getReadableDatabase();
        String selection = "joueur_equipe = ?";
        String[] selectionArgs = {nomEquipe};
        Cursor cursor = db.query("joueurs", null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                String nom = cursor.getString(cursor.getColumnIndexOrThrow("joueur_nom"));
                String poste = cursor.getString(cursor.getColumnIndexOrThrow("joueur_poste"));
                int numero = cursor.getInt(cursor.getColumnIndexOrThrow("joueur_numero"));
                Joueur joueur = new Joueur(nom, poste, numero, nomEquipe);
                joueurs.add(joueur);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();

        return joueurs;
    }
}
