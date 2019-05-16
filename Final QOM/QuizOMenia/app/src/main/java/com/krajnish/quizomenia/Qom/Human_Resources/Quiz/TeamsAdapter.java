package com.krajnish.quizomenia.Qom.Human_Resources.Quiz;

/**
 * Created by RACE on 11/16/2015.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.krajnish.quizomenia.R;

import java.util.ArrayList;


public class TeamsAdapter extends ArrayAdapter<Team> {

    Context context;
    private ArrayList<Team> teams;

    public TeamsAdapter(Context context, int textViewResourceId, ArrayList<Team> items) {
        super(context, textViewResourceId, items);
        this.context = context;
        this.teams = items;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.team, null);
        }
        Team o = teams.get(position);
        if (o != null) {
            TextView pos = (TextView) v.findViewById(R.id.position);
            TextView name = (TextView) v.findViewById(R.id.name);


            pos.setText(String.valueOf(o.getPosition()));
            name.setText(String.valueOf(o.getName()));

        }
        return v;
    }
}