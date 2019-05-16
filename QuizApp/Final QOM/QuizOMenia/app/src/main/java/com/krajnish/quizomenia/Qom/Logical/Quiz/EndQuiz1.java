package com.krajnish.quizomenia.Qom.Logical.Quiz;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.krajnish.quizomenia.Qom.Quantitative.Quiz.RajnishAplication;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.Select;
import com.krajnish.quizomenia.R;



public class EndQuiz1 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_quiz);
        Quiz1 startQuiz1 = ((RajnishAplication) getApplication()).getStartQuiz1();
        String result = "You Got " + startQuiz1.getRight() + "/" + startQuiz1.getNumRounds();
        // String comment = Helper.getResultComment(startQuiz.getRight(), startQuiz.getNumRounds(), getlevel());

        TextView results = (TextView) findViewById(R.id.endResult);
        results.setText(result);

        //handle button actions

        Button menu = (Button) findViewById(R.id.btnMenu);
        menu.setOnClickListener(this);
        Button answer = (Button) findViewById(R.id.btnAnswer);
        answer.setOnClickListener(this);

    }


    /**
     * Method to return the level of the Quiz
     */
    private int getlevel() {
        SharedPreferences update = getSharedPreferences(Select.UPDATE,0);
        int choose = update.getInt(Select.LEVEL,1);
        return choose;

    }
    /*
       * This method is to override the back button on the phone
       * to prevent users from navigating back in to the quiz
       */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                Toast.makeText(this, "Not allowed at this moment.",
                        Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMenu:
                finish();
                break;

            case R.id.btnAnswer:
                Intent i = new Intent(this, Answers1.class);
                startActivityForResult(i, Select.STARTTEST);
                finish();
                break;
        }

    }
}
