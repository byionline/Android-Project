package com.krajnish.quizomenia.Qom.Human_Resources.Quiz;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.krajnish.quizomenia.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HumanResourcesQuestion extends Fragment implements View.OnClickListener {
    Button btnDownload;
    View view;
    ListView listview;
    ArrayList<Team> teams = new ArrayList<Team>();
    public HumanResourcesQuestion() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_hrgeneral_question, container, false);
        final TextView textViewToChange = (TextView) view.findViewById(R.id.title);
        textViewToChange.setText(
                "Some Technical Questions");

        listview = (ListView) view.findViewById(R.id.listview);
        btnDownload = (Button) view.findViewById(R.id.btnDownload);
        btnDownload.setOnClickListener(this);

        ConnectivityManager connMgr = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        if (networkInfo != null && networkInfo.isConnected()) {
            btnDownload.setEnabled(true);
        } else {
            btnDownload.setEnabled(false);
            Toast.makeText(getActivity(), "No Internet connection!", Toast.LENGTH_LONG).show();

        }
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDownload:
                new DownloadWebpageTask(new AsyncResult() {
                    @Override
                    public void onResult(JSONObject object) {
                        processJson(object);
                    }

                    private void processJson(JSONObject object) {
                        try {
                            JSONArray rows = object.getJSONArray("rows");


                            for (int r = 0; r < rows.length(); ++r) {
                                JSONObject row = rows.getJSONObject(r);
                                JSONArray columns = row.getJSONArray("c");

                                int position = columns.getJSONObject(0).getInt("v");
                                String name = columns.getJSONObject(1).getString("v");

                                Team team = new Team(position, name);
                                teams.add(team);
                            }

                            final TeamsAdapter adapter = new TeamsAdapter(getActivity(), R.layout.team, teams);
                            listview.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }).execute("https://spreadsheets.google.com/tq?key=1P6qXj--2xt2qttIMlQiJNSxjLxd4pqXz2omQydGTJk4");

                //.execute("https://spreadsheets.google.com/tq?key=1tlyJxOpPLLHUN6cyMpCLIBcfUEquXDQ_QBuin2dp4fs");

                break;

        }
    }
}
//General with technical questions