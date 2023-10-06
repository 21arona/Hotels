package com.example.tpallfootball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tpallfootball.adapter.EquipeAdapter;
import com.example.tpallfootball.entities.Equipe;
import com.example.tpallfootball.managers.EquipeManager;

import java.util.List;

public class EquipesListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipes_list);

        ListView equipeListView = findViewById(R.id.equipe_list_view);
        EquipeManager equipeManager = new EquipeManager(this);

        // Récupérer la compétition sélectionnée depuis l'intent
        String competitionSelectionnee = getIntent().getStringExtra("competition");
        List<Equipe> equipes = equipeManager.getEquipesByCompetition(competitionSelectionnee);

        // Utiliser un adaptateur personnalisé (EquipeAdapter) au lieu de l'adaptateur par défaut (ArrayAdapter)
        EquipeAdapter equipeAdapter = new EquipeAdapter(this, equipes);
        equipeListView.setAdapter(equipeAdapter);
    }

}