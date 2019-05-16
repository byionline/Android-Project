package com.krajnish.quizomenia.Qom.Logical.Quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.krajnish.quizomenia.Qom.Quantitative.Quiz.RajnishAplication;
import com.krajnish.quizomenia.R;

import java.util.List;

 public class QuestionActivity1 extends Activity implements View.OnClickListener {
    private Question1 startquestion;
    private Quiz1 startquiz;
    private CountDownTimer cdtimer;
    private long total = 60000;
    TextView textViewTime;

    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        /**
         * configure Quiz and its question
         */

        startquiz = ((RajnishAplication) getApplication()).getStartQuiz1();
        startquestion  = startquiz.getNextquestion();
        final Button btnnext = (Button) findViewById(R.id.btnNext);
        btnnext.setOnClickListener(this);
       /* final Button btnend = (Button) findViewById(R.id.btnEnd);
        btnend.setOnClickListener(this);  */
        textViewTime = (TextView) findViewById(R.id.textViewTime);
        textViewTime.setText("01:00");

        /**
         * Update Question and its options
         */
        setQuestion();
//timer.start();
        // cdtimer.start();

        startCountDownTimer();

    }

    // final CounterClass timer = new CounterClass(60000, 1000);

    @Override
    public void onStart() {
        super.onStart();

        //  timer.cancel();
    }

    private void startCountDownTimer() {
        cdtimer = new CountDownTimer(total, 1000) {
            public void onTick(long millisUntilFinished) {
                //update total with the remaining time left
                total = millisUntilFinished;
                textViewTime.setText("Seconds Remaining: " +  millisUntilFinished/ 1000);
            }
            public void onFinish() {
                textViewTime.setText("done!");
                gotoActivity();
            }
        }.start();

    }

    @Override
    public void onResume() {
        super.onResume();


    }




    private void setQuestion() {
        //Set the question text from the current question
        String question = Utility1.capitalise(startquestion.getQuestion());
        TextView qtext = (TextView) findViewById(R.id.question);
        //qtext.setText(question);
        StringBuffer sb = new StringBuffer();

        qtext.setText( sb.append("Q").append(") ").append(question).append(" \n"));
        //Set options

        List<String> answers = startquestion.getQuestionOptions();
        TextView option1  = (TextView) findViewById(R.id.answer1);
        option1.setText(Utility1.capitalise(answers.get(0)));

        TextView option2  = (TextView) findViewById(R.id.answer2);
        option2.setText(Utility1.capitalise(answers.get(1)));

        TextView option3  = (TextView) findViewById(R.id.answer3);
        option3.setText(Utility1.capitalise(answers.get(2)));

        TextView option4  = (TextView) findViewById(R.id.answer4);
        option4.setText(Utility1.capitalise(answers.get(3)));
        TextView option5  = (TextView) findViewById(R.id.answer5);
        option5.setText(Utility1.capitalise(answers.get(4)));

    }





    @Override
    public void onClick(View v) {


        /**
         * Validating a checkbox that has been selected
         */
        if (!checkAnswer()) {
            Toast.makeText(this, "Select an option!", Toast.LENGTH_LONG).show();

            return;
        }
        /**
         * Check if Quiz ends
         */
        if (startquiz.isQuizOver()) {
            Intent i = new Intent(this, EndQuiz1.class);
            startActivity(i);
            cdtimer.cancel();
            finish();
        } else {
            Intent i = new Intent(this, QuestionActivity1.class);
            startActivity(i);
            cdtimer.cancel();
            finish();
        }
        /**
         * For End Test
         *
        switch (v.getId()) {


            case R.id.btnEnd:
                startquiz.isQuizOver();
                Intent i = new Intent(this, EndQuiz1.class);
                startActivity(i);
                cdtimer.cancel();
                finish();
                break;
        }  */
    }
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

    /**
     * check if a checkbox has been selected, if it selected check if its correct and update score
     * @return
     */
    private boolean checkAnswer() {
        String answer = getSelectedAnswer();
        if (answer == null) {
            //Log.d("Questions", "No Checkbox selection made - returning");
            return false;
        } else {
            //Log.d("Questions", "Valid Checkbox selection made - check if correct");
            if (startquestion.getAnswer().equalsIgnoreCase(answer)) {
                //Log.d("Questions", "Correct Answer!");
                startquiz.incrementRightAnswers();
            } else {
                //Log.d("Questions", "Incorrect Answer!");
                startquiz.incrementWrongAnswers();
            }
            return true;
        }
    }

    private String getSelectedAnswer() {
        RadioButton c1 = (RadioButton) findViewById(R.id.answer1);
        RadioButton c2 = (RadioButton) findViewById(R.id.answer2);
        RadioButton c3 = (RadioButton) findViewById(R.id.answer3);
        RadioButton c4 = (RadioButton) findViewById(R.id.answer4);
        RadioButton c5 = (RadioButton) findViewById(R.id.answer5);
        if (c1.isChecked()) {
            return c1.getText().toString();
        }
        if (c2.isChecked()) {
            return c2.getText().toString();
        }
        if (c3.isChecked()) {
            return c3.getText().toString();
        }
        if (c4.isChecked()) {
            return c4.getText().toString();
        }
        if (c5.isChecked()) {
            return c5.getText().toString();
        }

        return null;
    }
    /*

    public class CounterClass extends CountDownTimer {

        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);

        }

      timer
        public void onTick(long millisUntilFinished) {

           total = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
            System.out.println(hms);
            textViewTime.setText(hms);
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            textViewTime.setText("Time Up.");
            gotoActivity();
        }





    }
    */
    public void gotoActivity() {
        if (startquiz.isQuizOver()) {
            Intent i = new Intent(this, EndQuiz1.class);
            startActivity(i);
            cdtimer.cancel();
            finish();
        }
        else  {
            Intent i = new Intent(this, QuestionActivity1.class);
            startActivity(i);
            cdtimer.cancel();
            finish();
        }

    }
}
