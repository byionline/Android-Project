package com.krajnish.quizomenia.Qom.Quantitative.Quiz;

import android.app.Application;

import com.krajnish.quizomenia.Qom.Logical.Quiz.Quiz1;

public class RajnishAplication extends Application {
    private Quiz startQuiz;
    private Quiz1 startQuiz1;
    public Quiz getStartQuiz(){
        return startQuiz;
    }
    public void setStartQuiz(Quiz startQuiz){
        this.startQuiz = startQuiz;
    }


    public Quiz1 getStartQuiz1(){
        return startQuiz1;
    }
    public void setStartQuiz1(Quiz1 startQuiz1){
        this.startQuiz1 =startQuiz1;
    }
}
