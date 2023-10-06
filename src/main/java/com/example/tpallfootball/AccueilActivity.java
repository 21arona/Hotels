package com.example.tpallfootball;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.tpallfootball.adapter.MatchAdapter;
import com.example.tpallfootball.entities.Match;
import com.example.tpallfootball.helper.BdHelper;
import com.example.tpallfootball.managers.MatchManager;
import com.example.tpallfootball.ui.AccueilFragment;
import com.example.tpallfootball.ui.CompetitionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class AccueilActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private AccueilFragment accueilFragment = new AccueilFragment();
    private MatchManager matchManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        BdHelper.copyDatabaseFromAssets(this);

        setTitle("Matchs");

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame_layout, accueilFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_accueil) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame_layout, accueilFragment).commit();
                return true;
            } else if (item.getItemId() == R.id.menu_competition) {
                Intent intent = new Intent(AccueilActivity.this, CompetitionActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });

        matchManager = new MatchManager();
        ArrayList<Match> matchs = matchManager.getAllMatchs(this);

        ListView matchListView = findViewById(R.id.match_list_view);
        MatchAdapter matchAdapter = new MatchAdapter(this, matchs);
        matchListView.setAdapter(matchAdapter);
    }
}