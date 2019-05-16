package com.krajnish.quizomenia.Qom.Human_Resources.Quiz;

/**
 * Created by RACE on 11/16/2015.
 */

public class Team {
    private int position;
    private String name;


    public Team(int position, String name)
    {
        this.setPosition(position);
        this.setName(name);


    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}