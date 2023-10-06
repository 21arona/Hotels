package com.example.tpallfootball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tpallfootball.R;
import com.example.tpallfootball.adapter.MatchAdapter;
import com.example.tpallfootball.entities.Match;
import com.example.tpallfootball.managers.MatchManager;
import com.example.tpallfootball.ui.MatchsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MatchsActivity extends AppCompatActivity {

    private TextView tableTextView, fixtureTextView, teamsTextView;
    private ListView matchListView;

    private MatchsFragment matchsFragment = new MatchsFragment();
    private BottomNavigationView bottomNavigationView;

    private MatchManager matchManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matchs);

        matchManager = new MatchManager();

        tableTextView = findViewById(R.id.table_text_view);
        fixtureTextView = findViewById(R.id.fixtures_text_view);
        teamsTextView = findViewById(R.id.teams_text_view);

        matchListView = findViewById(R.id.match_list_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, matchsFragment).commit();


        tableTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchsActivity.this, ClassementActivity.class);
                startActivity(intent);
            }
        });

        fixtureTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MatchsActivity.this, MatchsActivity.class);
                //startActivity(intent);
            }
        });
        teamsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MatchsActivity.this, EquipesActivity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String selectedChampionnat = intent.getStringExtra("championnat");
        String competitionName = intent.getStringExtra("competition_name");

        TextView nomCompetitionTextView = findViewById(R.id.nom_competition_tv);
        nomCompetitionTextView.setText(competitionName);

        ArrayList<Match> allMatchs = matchManager.getAllMatchs(this);
        ArrayList<Match> matchsFiltres = new ArrayList<>();

        for (Match match : allMatchs) {
            if (match.getNomCompetition().equals(selectedChampionnat)) {
                matchsFiltres.add(match);
            }
        }
        MatchAdapter adapter = new MatchAdapter(this, matchsFiltres);
        matchListView.setAdapter(adapter);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_accueil) {
                Intent intente = new Intent(MatchsActivity.this, AccueilActivity.class);
                startActivity(intente);
                return true;
            } else if (item.getItemId() == R.id.menu_competition) {
                Intent intente = new Intent(MatchsActivity.this, CompetitionActivity.class);
                startActivity(intente);
                return true;
            }
            return false;
        });
    }
}