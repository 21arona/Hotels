package com.example.tpallfootball.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tpallfootball.R;
import com.example.tpallfootball.entities.Match;

import java.util.ArrayList;
import java.util.List;

public class MatchAdapter extends ArrayAdapter<Match> {
    private LayoutInflater inflater;

    public MatchAdapter(Context context, ArrayList<Match> matches) {
        super(context, 0, matches);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = inflater.inflate(R.layout.list_item_match, parent, false);
        }

        // Obtenez le match à la position donnée
        Match match = getItem(position);

        // Récupérez les TextView du layout list_item_match.xml
        TextView equipeDomicileTv = itemView.findViewById(R.id.equipe_domicile_tv);
        TextView scoreDomicileTv = itemView.findViewById(R.id.score_domicile_tv);
        TextView scoreExterieurTv = itemView.findViewById(R.id.score_exterieur_tv);
        TextView equipeExterieurTv = itemView.findViewById(R.id.equipe_exterieure_tv);

        // Définissez les valeurs du match sur les TextView
        equipeDomicileTv.setText(match.getNomEquipeDomicile());
        scoreDomicileTv.setText(String.valueOf(match.getScoreDomicile()));
        scoreExterieurTv.setText(String.valueOf(match.getScoreExterieur()));
        equipeExterieurTv.setText(match.getNomEquipeExterieure());

        return itemView;
    }
}

