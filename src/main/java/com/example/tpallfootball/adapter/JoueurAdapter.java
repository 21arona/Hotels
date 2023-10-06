package com.example.tpallfootball.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tpallfootball.R;
import com.example.tpallfootball.entities.Joueur;

import java.util.List;

public class JoueurAdapter extends ArrayAdapter<Joueur> {

    public JoueurAdapter(Context context, List<Joueur> joueurs) {
        super(context, 0, joueurs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_joueurs, parent, false);
        }

        Joueur joueur = getItem(position);

        TextView nomTextView = convertView.findViewById(R.id.nomTextView);
        TextView posteTextView = convertView.findViewById(R.id.posteTextView);
        TextView numeroTextView = convertView.findViewById(R.id.numeroTextView);

        nomTextView.setText(joueur.getNom());
        posteTextView.setText(joueur.getPoste());
        numeroTextView.setText(String.valueOf(joueur.getNumero()));

        return convertView;
    }

}

