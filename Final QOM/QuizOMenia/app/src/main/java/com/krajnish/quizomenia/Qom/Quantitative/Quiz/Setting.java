package com.krajnish.quizomenia.Qom.Quantitative.Quiz;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;

import com.krajnish.quizomenia.R;

public class Setting extends Activity implements OnClickListener {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        /**
         * set listener on update button
         */
        Button updateBtn = (Button) findViewById(R.id.btnUpdate);
        updateBtn.setOnClickListener(this);

        /**
         * Set selected button if saved
         */
        updateButtonWithPreferences();

    }

    /**
     * Method to update default check box
     */
    private void updateButtonWithPreferences() {
        RadioButton a1 = (RadioButton) findViewById(R.id.level0);
        RadioButton a2 = (RadioButton) findViewById(R.id.level1);
        SharedPreferences setting  = getSharedPreferences(Select.UPDATE, 0);
        int choose = setting.getInt(Select.LEVEL,Select.LEVEL0);
        switch (choose){
            case Select.LEVEL0:
                a1.toggle();
                break;
            case Select.LEVEL1:
                a2.toggle();
                break;

        }
    }

    @Override
    public void onClick(View v) {

        /**
         * Check Which update is set and return to menu
         */
        if (!checkSelected()){
            return;

        }
        else
        {
            SharedPreferences setting  = getSharedPreferences(Select.UPDATE, 0);
            Editor e = setting.edit();
            e.putInt(Select.LEVEL,getSelectedUpdate());
            e.commit();
            finish();
        }

    }

    /**
     * Method to check which checkbox is selected
     * @return
     */
    private boolean checkSelected() {
         RadioButton a1 = (RadioButton) findViewById(R.id.level0);
        RadioButton a2 = (RadioButton) findViewById(R.id.level1);
        return (a1.isChecked() || a2.isChecked());
    }
    /**
     * Get selected update
     */
    private int getSelectedUpdate(){
        RadioButton a1 = (RadioButton) findViewById(R.id.level0);
      //  RadioButton a2 = (RadioButton) findViewById(R.id.level1);
        if (a1.isChecked()){
            return Select.LEVEL0;
        }

            return Select.LEVEL1;

    }
}
