package com.example.tpallfootball;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tpallfootball.R;
import com.example.tpallfootball.adapter.ClassementAdapter;
import com.example.tpallfootball.entities.Classement;
import com.example.tpallfootball.managers.ClassementManager;

import java.util.ArrayList;

public class ClassementActivity extends AppCompatActivity {
    ClassementAdapter classementAdapter;
    ListView listViewClassement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);

        // Afficher le classement des championnats
        listViewClassement = findViewById(R.id.listview_classement);
        ArrayList<Classement>classements = ClassementManager.getAll(this);
        classementAdapter = new ClassementAdapter(this,R.layout.classement_liste,classements);
        listViewClassement.setAdapter(classementAdapter);

        // Trier les championnants


    }
}