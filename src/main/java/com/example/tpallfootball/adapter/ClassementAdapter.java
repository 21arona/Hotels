package com.example.tpallfootball.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tpallfootball.R;
import com.example.tpallfootball.entities.Classement;

import org.w3c.dom.Text;

import java.util.List;

public class ClassementAdapter extends ArrayAdapter<Classement> {
    int monClassement;

    public ClassementAdapter(@NonNull Context context, int classement, @NonNull List<Classement> objects) {
        super(context, classement, objects);
        monClassement = classement;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // final View view;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(monClassement, parent, false);
        }
        Classement classement = getItem(position);

        TextView row_equipe = convertView.findViewById(R.id.tv_row_equipe);
        TextView row_matchs = convertView.findViewById(R.id.tv_matchs_joues);
        TextView row_points = convertView.findViewById(R.id.tv_points_equipes);
        TextView row_defaites = convertView.findViewById(R.id.tv_defaites_equipes);
        TextView row_victoires = convertView.findViewById(R.id.tv_victoires_equipes);

        row_equipe.setText(classement.getNomEquipe());

        row_points.setText(String.valueOf(classement.getNbPoints()));

        row_matchs.setText(String.valueOf(classement.getMatchs_joues()));
        row_defaites.setText(String.valueOf(classement.getNb_defaites()));
        row_victoires.setText(String.valueOf(classement.getNb_victoires()));

        return convertView;

    }

}
