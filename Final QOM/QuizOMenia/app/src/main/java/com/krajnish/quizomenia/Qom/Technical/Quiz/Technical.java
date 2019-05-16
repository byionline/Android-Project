package com.krajnish.quizomenia.Qom.Technical.Quiz;

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

public class Technical extends ActionBarActivity implements AdapterView.OnItemClickListener{

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
        navArray.add("C Language");
        navArray.add("C++");
        navArray.add("C#");
        navArray.add("Java");


        navArray.add("Data Structure");
        navArray.add(".Net");
        navArray.add("Software Testing");
        navArray.add("Networking");
        navArray.add("Operating System");
        navArray.add("Database Management");

        navArray.add("Microsoft SQL");
        navArray.add("UNIX");
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
                 Technical_C_Language c_languageFragment = new Technical_C_Language();
                 fragmentTransaction = fragmentManager.beginTransaction();
                 fragmentTransaction.replace(R.id.fragmentholder,c_languageFragment);
                 fragmentTransaction.commit();
                 break;

            case 1:
                Technical_C_plus_plus c_plus_plusFragment = new Technical_C_plus_plus();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,c_plus_plusFragment);
                fragmentTransaction.commit();
                break;
            case 2:
                Technical_C_hash c_hashFragment = new Technical_C_hash();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,c_hashFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                Technical_Java javaFragment = new Technical_Java();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,javaFragment);
                fragmentTransaction.commit();
                break;
            case 4:
                Technical_Data_Structure data_structureFragment = new Technical_Data_Structure();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,data_structureFragment);
                fragmentTransaction.commit();
                break;
            case 5:
                Technical_Dot_Net dot_netFragment = new Technical_Dot_Net();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,dot_netFragment);
                fragmentTransaction.commit();
                break;
            case 6:
                Technical_Software_testing software_testingFragment = new Technical_Software_testing();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,software_testingFragment);
                fragmentTransaction.commit();
                break;
            case 7:
                Technical_Networking networkingFragment = new Technical_Networking();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,networkingFragment);
                fragmentTransaction.commit();
                break;
            case 8:
                Technical_Operating_System operating_systemFragment = new Technical_Operating_System();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,operating_systemFragment);
                fragmentTransaction.commit();
                break;
            case 9:
                Technical_Database_Management database_managementFragment = new Technical_Database_Management();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,database_managementFragment);
                fragmentTransaction.commit();
                break;
            case 10:
                Technical_Microsoft_SQL microsoft_sqlFragment = new Technical_Microsoft_SQL();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,microsoft_sqlFragment);
                fragmentTransaction.commit();
                break;
            case 11:
                Technical_Unix unixFragment = new Technical_Unix();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,unixFragment);
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
