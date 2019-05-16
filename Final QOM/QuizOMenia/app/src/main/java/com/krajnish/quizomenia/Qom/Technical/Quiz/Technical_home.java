package com.krajnish.quizomenia.Qom.Technical.Quiz;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.krajnish.quizomenia.R;

public class Technical_home extends Fragment {

    public Technical_home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.activity_technical_home, container, false);


        // Inflate the layout for this fragment
        //  layout contains   list view
        View view = inflater.inflate(R.layout.activity_quiz_home, container, false);

        //now   initialize  list view
        ListView listview =(ListView)view.findViewById(R.id.mainListView);
        //EDITED Code
        String[] items = new String[] {"Topic Covered", "C Language", "C++","C#","Java",
                "Data Structure",".Net","Software Testing","Networking","Operating System",
        "Database Management","Microsoft SQL","UNIX"};
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(getActivity(), R.layout.listviewcolor, items);

        listview.setAdapter(adapter);

        //To have custom list view use this :   CustomeAdapter class
        // listview.setadapter(new CustomeAdapter(getActivity()));
        //getActivty is used instead of Context
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

}
