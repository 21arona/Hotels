package com.example.tpallfootball.managers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tpallfootball.entities.Competition;
import com.example.tpallfootball.helper.BdHelper;

import java.util.ArrayList;

public class CompetitionManager {

    public static void afficherCompetitionsDansTextViews(TextView premierLeagueTextView, TextView ligaTextView,
                                                         TextView ligue1TextView, TextView serieATextView, TextView mlsTextView) {

        BdHelper dbHelper = new BdHelper(premierLeagueTextView.getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Récupérez les compétitions de la base de données
        ArrayList<Competition> competitions = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM competitions", null);
        if(cursor.moveToFirst()){
            do{
                Competition competition = new Competition(cursor);
                competitions.add(competition);
            } while(cursor.moveToNext());
        }
        cursor.close();
        dbHelper.close();

        // parcourir liste compétitions et affichez le nom dans chaque TextView
        for (Competition competition : competitions) {
            String nomCompetition = competition.getNom();
            switch (nomCompetition) {
                case "Premier League":
                    premierLeagueTextView.setText(nomCompetition);
                    break;
                case "Liga":
                    ligaTextView.setText(nomCompetition);
                    break;
                case "Ligue 1":
                    ligue1TextView.setText(nomCompetition);
                    break;
                case "Serie A":
                    serieATextView.setText(nomCompetition);
                    break;
                case "MLS":
                    mlsTextView.setText(nomCompetition);
                    break;
                default:
                    break;
            }
        }
    }
}
