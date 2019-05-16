package com.krajnish.quizomenia;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import com.krajnish.quizomenia.Qom.About_Us.Quiz.About;
import com.krajnish.quizomenia.Qom.English.Quiz.English;
import com.krajnish.quizomenia.Qom.Human_Resources.Quiz.Humanres;
import com.krajnish.quizomenia.Qom.Logical.Quiz.Logical;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.Quantitative;
import com.krajnish.quizomenia.Qom.Technical.Quiz.Technical;


public class QomMainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qom_main);
    }

    //Button Click for Logical

    public void ButtonClick1(View view) {
        goToLogicalActivity();
    }

    private void goToLogicalActivity() {
        Intent intent = new Intent(this,Logical.class);
        startActivity(intent);
        finish();

    }

    //Button Click for English

    public void ButtonClick2(View view) {
        goToEnglishActivity();
    }

    private void goToEnglishActivity() {
        Intent intent = new Intent(this,English.class);
        startActivity(intent);
        finish();
    }
    //Button Click for Quantitative

    public void ButtonClick3(View view) {
        goToQuantitativeActivity();
    }

    private void goToQuantitativeActivity() {
        Intent intent = new Intent(this,Quantitative.class);
        startActivity(intent);
        finish();
    }
    //Button Click for Technical

    public void ButtonClick4(View view) {
        goTotechnicalActivity();
    }

    private void goTotechnicalActivity() {
        Intent intent = new Intent(this,Technical.class);
        startActivity(intent);
        finish();
    }
    //Button Click for Human Resources

    public void ButtonClick5(View view) {
        goToHumanResActivity();
    }

    private void goToHumanResActivity() {
        Intent intent = new Intent(this,Humanres.class);
        startActivity(intent);
        finish();
    }
    //Button Click for AboutUs

    public void ButtonClick6(View view) {
        goToAboutActivity();
    }

    private void goToAboutActivity() {
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
        finish();
    }
    private Boolean exit = false;
    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }

    }


}
