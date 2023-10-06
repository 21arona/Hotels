package com.example.tpallfootball.managers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tpallfootball.entities.Classement;
import com.example.tpallfootball.entities.Equipe;
import com.example.tpallfootball.entities.Joueur;
import com.example.tpallfootball.helper.BdHelper;
import com.example.tpallfootball.services.ConnexionBd;

import java.util.ArrayList;
import java.util.List;

public class EquipeManager {
    private BdHelper bdHelper;

    public EquipeManager(Context context) {
        bdHelper = new BdHelper(context);
    }

    public List<Equipe> getEquipesByCompetition(String competitionNom) {
        List<Equipe> equipes = new ArrayList<>();

        SQLiteDatabase db = bdHelper.getReadableDatabase();
        String selection = "competition_nom = ?";
        String[] selectionArgs = {competitionNom};
        Cursor cursor = db.query("equipes", null, selection, selectionArgs, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("id_equipe"));
                String nomEquipe = cursor.getString(cursor.getColumnIndexOrThrow("equipe_nom"));
                int positionClassement = cursor.getInt(cursor.getColumnIndexOrThrow("position_classement"));
                Equipe equipe = new Equipe(nomEquipe, competitionNom, positionClassement);
                equipe.setId_equipe(id);
                equipes.add(equipe);
            } while (cursor.moveToNext());
            cursor.close();
        }
        db.close();

        return equipes;
    }


}
