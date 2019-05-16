package com.krajnish.quizomenia.Qom.Quantitative.Quiz;

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

public class Quantitative extends ActionBarActivity implements AdapterView.OnItemClickListener{

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
        navArray.add("HCF & LCM");
         navArray.add("Average");
         navArray.add("Problem on Ages");
        navArray.add("Percentage");
        navArray.add("Profit & Loss");
        navArray.add("Ratio & Proportion");
        navArray.add("Partnership");
        navArray.add("Chain Rule");
        navArray.add("Time & Work");
         navArray.add("Time & Distance");
        navArray.add("Problem on Trains");
        navArray.add("Boats & Streams");
        navArray.add("Alligation or Mixture");
        navArray.add("Simple Interest");

        navArray.add("Compound Interest");
        navArray.add("Volume & Surface Areas");
        navArray.add("Clock");
        navArray.add("Permutations & Combinations");
        navArray.add("Probability");

        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
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
                 Quantitative_HCF_LCM hcf_lcmFragment = new Quantitative_HCF_LCM();
                 fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.fragmentholder,hcf_lcmFragment);
                 fragmentTransaction.commit();
                break;

            case 1:
                Quantitative_Average averageFragment = new Quantitative_Average();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,averageFragment);
                fragmentTransaction.commit();
                break;
             case 2:
                Quantitative_Problem_on_Ages problem_on_agesFragment = new Quantitative_Problem_on_Ages();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,problem_on_agesFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                Quantitative_Percentage percentageFragment = new Quantitative_Percentage();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,percentageFragment);
                fragmentTransaction.commit();
                break;
            case 4:
                Quantitative_Profit_Loss profit_lossFragment = new Quantitative_Profit_Loss();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,profit_lossFragment);
                fragmentTransaction.commit();
                break;
            case 5:
                Quantitative_Ratio_Proportion ratio_proportionFragment = new Quantitative_Ratio_Proportion();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,ratio_proportionFragment);
                fragmentTransaction.commit();
                break;
            case 6:
                Quantitative_Partnership partnershipFragment = new Quantitative_Partnership();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,partnershipFragment);
                fragmentTransaction.commit();
                break;
            case 7:
                Quantitative_Chain_Rule chain_ruleFragment = new Quantitative_Chain_Rule();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,chain_ruleFragment);
                fragmentTransaction.commit();
                break;
            case 8:
                Quantitative_Time_Work time_workFragment = new Quantitative_Time_Work();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,time_workFragment);
                fragmentTransaction.commit();
                break;
               case 9:
                Quantitative_Time_Distance time_distanceFragment = new Quantitative_Time_Distance();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,time_distanceFragment);
                fragmentTransaction.commit();
                break;
            case 10:
                Quantitative_Problem_on_Trains problem_on_trainsFragment = new Quantitative_Problem_on_Trains();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,problem_on_trainsFragment);
                fragmentTransaction.commit();
                break;
            case 11:
                Quantitative_Boats_Streams boats_streamsFragment = new Quantitative_Boats_Streams();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,boats_streamsFragment);
                fragmentTransaction.commit();
                break;
            case 12:
                Quantitative_Alligation_Mixture alligation_mixtureFragment = new Quantitative_Alligation_Mixture();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,alligation_mixtureFragment);
                fragmentTransaction.commit();
                break;
            case 13:
                Quantitative_Simple_Interest simple_interestFragment = new Quantitative_Simple_Interest();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,simple_interestFragment);
                fragmentTransaction.commit();
                break;
            case 14:
                Quantitative_Compound_Interest simple_compound_interestFragment = new Quantitative_Compound_Interest();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,simple_compound_interestFragment);
                fragmentTransaction.commit();
                break;

            case 15:
                Quantitative_Volume_Surface_Areas volume_surface_areasFragment = new Quantitative_Volume_Surface_Areas();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,volume_surface_areasFragment);
                fragmentTransaction.commit();
                break;
            case 16:
                Quantitative_Clocks calendar_clocksFragment = new Quantitative_Clocks();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,calendar_clocksFragment);
                fragmentTransaction.commit();
                break;
            case 17:
                Quantitative_Permutations_Combinations permutations_combinationsFragment = new Quantitative_Permutations_Combinations();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,permutations_combinationsFragment);
                fragmentTransaction.commit();
                break;
            case 18:
                Quantitative_Probability probabilityFragment = new Quantitative_Probability();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,probabilityFragment);
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
