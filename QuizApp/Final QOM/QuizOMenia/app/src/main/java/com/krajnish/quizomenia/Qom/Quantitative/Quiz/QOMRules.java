package com.krajnish.quizomenia.Qom.Quantitative.Quiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.krajnish.quizomenia.R;

public   class QOMRules extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qomrules);
        //handle button actions
        Button finishBtn = (Button) findViewById(R.id.btnBack);
        finishBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBack:
                finish();
        }
    }
}
