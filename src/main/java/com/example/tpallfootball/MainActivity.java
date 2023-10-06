package com.example.tpallfootball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tpallfootball.helper.BdHelper;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        BdHelper dbHelper = new BdHelper(this);

//        try {
//            // Copier la base de données depuis les ressources de l'application
//            dbHelper.copyDatabaseFromAssets();
//
//            // Récupérer toutes les données de la base de données
//            ArrayList<String> data = dbHelper.getAllData();
//
//            //afficher donnees dans un TextView
//            TextView dataTextView = findViewById(R.id.dataTextView);
//            for (String value : data) {
//                dataTextView.append(value + "\n");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}