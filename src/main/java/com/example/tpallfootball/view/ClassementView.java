package com.example.tpallfootball.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tpallfootball.R;
import com.example.tpallfootball.entities.Classement;
import com.example.tpallfootball.managers.ClassementManager;

import java.util.ArrayList;

public class ClassementView extends LinearLayout {

    private Classement classement;
    private Button btn_pl,btn_liga,btn_mls,btn_ligue1,btn_serie_a;

    public ClassementView(Context context,Classement classement){
        super(context);
        this.classement=classement;
        init();
    }
    public void init(){
        LayoutInflater.from(getContext()).inflate(R.layout.classement_liste,this);
        // Ajoutons les evenements sur le listener

        btn_pl = findViewById(R.id.btn_premier_league);
        btn_pl.setOnClickListener(v -> handleClickBtnPl());

        btn_liga = findViewById(R.id.btn_liga);
        btn_liga.setOnClickListener(v -> handleClickBtnLiga());

        btn_mls = findViewById(R.id.btn_mls);
        btn_mls.setOnClickListener(v -> handleClickBtnMls());

        btn_ligue1 = findViewById(R.id.btn_ligue_1);
        btn_ligue1.setOnClickListener(v -> handleClickBtnLigue1());

        btn_serie_a = findViewById(R.id.btn_serie_a);
        btn_serie_a.setOnClickListener(v -> handleClickBtnSerieA());

    }

    private void handleClickBtnSerieA() {
    }

    private void handleClickBtnLigue1() {

    }

    private void handleClickBtnMls() {

    }

    private void handleClickBtnLiga() {

    }

    private void handleClickBtnPl() {

    }
}
