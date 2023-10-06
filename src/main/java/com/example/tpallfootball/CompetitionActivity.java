package com.example.tpallfootball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tpallfootball.helper.BdHelper;
import com.example.tpallfootball.managers.CompetitionManager;
import com.example.tpallfootball.ui.CompetitionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CompetitionActivity extends AppCompatActivity {
    private TextView premierLeagueTextView;
    private TextView ligaTextView;
    private TextView ligue1TextView;
    private TextView serieATextView;
    private TextView mlsTextView;

    private BottomNavigationView bottomNavigationView;
    private CompetitionFragment competitionFragment = new CompetitionFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competition);

        premierLeagueTextView = findViewById(R.id.tv_premier_league_competitions);
        ligaTextView = findViewById(R.id.tv_liga_competitions);
        ligue1TextView = findViewById(R.id.tv_ligue1_competitions);
        serieATextView = findViewById(R.id.tv_seriea_competitions);
        mlsTextView = findViewById(R.id.tv_mls_competitions);

        BdHelper.copyDatabaseFromAssets(this);

        // pour afficher les compétitions dans les TextView correspondants
        CompetitionManager.afficherCompetitionsDansTextViews(premierLeagueTextView, ligaTextView, ligue1TextView, serieATextView, mlsTextView);

        premierLeagueTextView.setOnClickListener(v -> {
            Intent intent = new Intent(CompetitionActivity.this, MatchsActivity.class);
            intent.putExtra("championnat", "Premier League");
            intent.putExtra("competition_name", premierLeagueTextView.getText().toString());
            startActivity(intent);
        });

        ligaTextView.setOnClickListener(v -> {
            Intent intent = new Intent(CompetitionActivity.this, MatchsActivity.class);
            intent.putExtra("championnat", "Liga");
            intent.putExtra("competition_name", ligaTextView.getText().toString());
            startActivity(intent);
        });

        ligue1TextView.setOnClickListener(v -> {
            Intent intent = new Intent(CompetitionActivity.this, MatchsActivity.class);
            intent.putExtra("championnat", "Ligue 1");
            intent.putExtra("competition_name", ligue1TextView.getText().toString());
            startActivity(intent);
        });

        serieATextView.setOnClickListener(v -> {
            Intent intent = new Intent(CompetitionActivity.this, MatchsActivity.class);
            intent.putExtra("championnat", "Serie A");
            intent.putExtra("competition_name", serieATextView.getText().toString());
            startActivity(intent);
        });

        mlsTextView.setOnClickListener(v -> {
            Intent intent = new Intent(CompetitionActivity.this, MatchsActivity.class);
            intent.putExtra("championnat", "MLS");
            intent.putExtra("competition_name", mlsTextView.getText().toString());
            startActivity(intent);
        });

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame_layout, new CompetitionFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_accueil) {
                Intent intent = new Intent(CompetitionActivity.this, AccueilActivity.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.menu_competition) {
                Intent intent = new Intent(CompetitionActivity.this, CompetitionActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

    }

}