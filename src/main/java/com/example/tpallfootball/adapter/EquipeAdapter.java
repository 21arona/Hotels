package com.example.tpallfootball.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tpallfootball.R;
import com.example.tpallfootball.entities.Equipe;

import java.util.List;

public class EquipeAdapter extends ArrayAdapter<Equipe> {
    private Context context;
    private List<Equipe> equipeList;

    public EquipeAdapter(Context context, List<Equipe> equipeList) {
        super(context, 0, equipeList);
        this.context = context;
        this.equipeList = equipeList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_equipes, parent, false);
        }

        Equipe equipe = equipeList.get(position);

        TextView nomEquipeTextView = convertView.findViewById(R.id.nom_equipe_text_view);
        nomEquipeTextView.setText(equipe.getNomEquipe());

        return convertView;
    }
}
