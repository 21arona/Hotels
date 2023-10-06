package com.example.tpallfootball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tpallfootball.R;
import com.example.tpallfootball.adapter.JoueurAdapter;
import com.example.tpallfootball.entities.Joueur;
import com.example.tpallfootball.helper.BdHelper;
import com.example.tpallfootball.managers.JoueurManager;
import com.example.tpallfootball.ui.EquipeFragment;
import com.example.tpallfootball.ui.JoueurFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class JoueursActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private JoueurFragment joueurFragment = new JoueurFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joueurs);

        ListView listView = findViewById(R.id.ll_joueurs_main);
        JoueurManager joueurManager = new JoueurManager(this);

        // récupérer le nom de l'équipe sélectionnée à partir de l'intent
        String nomEquipe = getIntent().getStringExtra("nomEquipe");

        // récupérer la liste des joueurs en fonction de l'équipe sélectionnée
        List<Joueur> joueurs = joueurManager.getJoueursByEquipe(nomEquipe);

        // créer un adaptateur personnalisé pour afficher les joueurs dans la ListView
        JoueurAdapter joueurAdapter = new JoueurAdapter(this, joueurs);
        listView.setAdapter(joueurAdapter);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame_layout, joueurFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_accueil) {
                Intent intent = new Intent(JoueursActivity.this, AccueilActivity.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.menu_competition) {
                Intent intent = new Intent(JoueursActivity.this, CompetitionActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }
}