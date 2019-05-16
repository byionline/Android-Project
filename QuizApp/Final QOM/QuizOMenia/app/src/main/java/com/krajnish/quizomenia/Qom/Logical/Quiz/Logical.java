package com.krajnish.quizomenia.Qom.Logical.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.krajnish.quizomenia.QomMainActivity;
import com.krajnish.quizomenia.R;

import java.util.ArrayList;

public class Logical extends ActionBarActivity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_drawer);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        navList = (ListView)findViewById(R.id.navlist);
        ArrayList<String> navArray = new ArrayList<String>();
      //  navArray.add("Home");
        navArray.add("Number Series");
        navArray.add("Letters");
        navArray.add("Essential Part");
        navArray.add("Analogies");
        navArray.add("Analyzing Arguments");
        navArray.add("Statement and Assumption");
        navArray.add("Course of Action");
        navArray.add("Statement and Conclusion");
        navArray.add("Course and Effect");
        navArray.add("Statement and Argument");
        navArray.add("Blood Relation");
        navArray.add("Logical Sequence of Words");
        navArray.add("Direction Sense ");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,navArray);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listviewcolor,navArray);

        navList.setAdapter(adapter);
        navList.setOnItemClickListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        fragmentManager = getSupportFragmentManager();

        loadSelection(0);



    }
    /**
     * Activity Life  cycle
     *
     * @param
     * @return
     */

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void loadSelection(int i){
        navList.setItemChecked(i,true);

        switch (i){

            case 0:
                Logical_Number_Series number_seriesFragment = new Logical_Number_Series();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,number_seriesFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                Logical_Letters logical_lettersFragment = new Logical_Letters();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,logical_lettersFragment);
                fragmentTransaction.commit();
                break;

            case 2:
                Logical_Essential_Part essential_partFragment = new Logical_Essential_Part();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,essential_partFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                Logical_Analogies analogiesFragment = new Logical_Analogies();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,analogiesFragment);
                fragmentTransaction.commit();
                break;
             case 4:
                Logical_Analyzing_Arguments analyzing_argumentsFragment = new Logical_Analyzing_Arguments();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,analyzing_argumentsFragment);
                fragmentTransaction.commit();
                break;
            case 5:
                Logical_Statement_and_Assumption statement_and_assumptionFragment = new Logical_Statement_and_Assumption();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,statement_and_assumptionFragment);
                fragmentTransaction.commit();
                break;
            case 6:
                Logical_Course_of_Action course_of_actionFragment = new Logical_Course_of_Action();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,course_of_actionFragment);
                fragmentTransaction.commit();
                break;
            case 7:
                Logical_Statement_and_Conclusion statement_and_conclusionFragment = new Logical_Statement_and_Conclusion();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,statement_and_conclusionFragment);
                fragmentTransaction.commit();
                break;
            case 8:
                Logical_Course_and_Effect course_and_effectFragment = new Logical_Course_and_Effect();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,course_and_effectFragment);
                fragmentTransaction.commit();
                break;
            case 9:
                Logical_Statement_and_Argument statement_and_argumentFragment = new Logical_Statement_and_Argument();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,statement_and_argumentFragment);
                fragmentTransaction.commit();
                break;
            case 10:
                Logical_Blood_Relation blood_relationFragment = new Logical_Blood_Relation();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,blood_relationFragment);
                fragmentTransaction.commit();
                break;

            case 11:
                Logical_Logical_Sequence_of_Words logical_logical_sequence_of_wordsFragment = new Logical_Logical_Sequence_of_Words();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,logical_logical_sequence_of_wordsFragment);
                fragmentTransaction.commit();
                break;
            case 12:
                Logical_Direction_Sense direction_senseFragment = new Logical_Direction_Sense();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,direction_senseFragment);
                fragmentTransaction.commit();
                break;



        }

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Logical Back To Main View
        if (id == R.id.action_back) {
            backToMain();

            return true;
        }else if (id == android.R.id.home){
            if (drawerLayout.isDrawerOpen(navList)){
                drawerLayout.closeDrawer(navList);
            }else{
                drawerLayout.openDrawer(navList);
            }
        }

        return super.onOptionsItemSelected(item);
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
// Back Button action
    private void backToMain() {
        Intent intent = new Intent(this,QomMainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadSelection(position);

        drawerLayout.closeDrawer(navList);
    }

}
