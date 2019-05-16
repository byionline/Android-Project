package com.krajnish.quizomenia.Qom.Logical.Quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.krajnish.quizomenia.Qom.Quantitative.Quiz.RajnishAplication;
import com.krajnish.quizomenia.R;

public class Answers1 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);
        Quiz1 startQuiz1 = ((RajnishAplication) getApplication()).getStartQuiz1();

        TextView results = (TextView) findViewById(R.id.answers);
        String answers = Utility1.getAnswers(startQuiz1.getQuestions());
        results.setText(answers);

        //handle button actions
        Button finishBtn = (Button) findViewById(R.id.btnBack);
        finishBtn.setOnClickListener(this);
    }


    /*
    * This method is to override the back button on the phone
    * to prevent users from navigating back in between the quiz
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
            case R.id.btnBack:
                finish();
        }
    }
}
