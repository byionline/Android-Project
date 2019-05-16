package com.krajnish.quizomenia.Qom.Logical.Quiz;

import android.app.Application;

public class RajnishAplication1 extends Application {
    private Quiz1 startQuiz;
    public Quiz1 getStartQuiz(){
        return startQuiz;
    }
    public void setStartQuiz(Quiz1 startQuiz){
        this.startQuiz = startQuiz;
    }
}
