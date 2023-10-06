package com.example.tpallfootball;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tpallfootball.R;
import com.example.tpallfootball.ui.AccueilFragment;
import com.example.tpallfootball.ui.CompetitionFragment;
import com.example.tpallfootball.ui.EquipeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EquipesActivity extends AppCompatActivity {

    private LinearLayout cityLayout;
    private LinearLayout realLayout;
    private LinearLayout montrealLayout;
    private LinearLayout juventusLayout;
    private LinearLayout psgLayout;
    private BottomNavigationView bottomNavigationView;
    private EquipeFragment equipeFragment = new EquipeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes);


        /*Spinner competitionSpinner = findViewById(R.id.competition_spinner);
        competitionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String competitionSelectionnee = parent.getItemAtPosition(position).toString();
                Intent intent = new Intent(EquipesActivity.this, EquipesListActivity.class);
                intent.putExtra("competition", competitionSelectionnee);
                startActivity(intent);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/


        cityLayout = findViewById(R.id.cityLayout);
        realLayout = findViewById(R.id.realLayout);
        montrealLayout = findViewById(R.id.montrealLayout);
        juventusLayout = findViewById(R.id.juventusLayout);
        psgLayout = findViewById(R.id.parisLayout);

        cityLayout.setOnClickListener(v -> lancerJoueursActivity("Manchester City"));

        realLayout.setOnClickListener(v -> lancerJoueursActivity("Real Madrid"));

        montrealLayout.setOnClickListener(v -> lancerJoueursActivity("Montreal CF"));

        juventusLayout.setOnClickListener(v -> lancerJoueursActivity("Juventus"));

        psgLayout.setOnClickListener(v -> lancerJoueursActivity("Paris Saint-Germain"));

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame_layout, equipeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.menu_accueil) {
                Intent intent = new Intent(EquipesActivity.this, AccueilActivity.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.menu_competition) {
                Intent intent = new Intent(EquipesActivity.this, CompetitionActivity.class);
                startActivity(intent);
                return true;
            }
            return false;
        });
    }

    private void lancerJoueursActivity(String equipe) {
        Intent intent = new Intent(EquipesActivity.this, JoueursActivity.class);
        intent.putExtra("nomEquipe", equipe);
        startActivity(intent);
    }
}