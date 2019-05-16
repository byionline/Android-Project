package com.krajnish.quizomenia.Qom.English.Quiz;

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

public class English extends ActionBarActivity implements AdapterView.OnItemClickListener{

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
       // navArray.add("Home");
        navArray.add("Antonyms");
        navArray.add("Synonyms");
        navArray.add("Change of Speech");
        navArray.add("Change of Voice");
        navArray.add("Correct Spellings");
        navArray.add("One Word Substitutes");
        navArray.add("Related Pair Words");
        navArray.add("Sentence Correction");
        navArray.add("Selecting Words");
        navArray.add("Sentence Improvement");
        navArray.add("Spotting Errors");
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
                Antonyms antonymsFragment = new Antonyms();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,antonymsFragment);
                fragmentTransaction.commit();
                break;
            case 1:
                Synonyms synonymsFragment = new Synonyms();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,synonymsFragment);
                fragmentTransaction.commit();
                break;
            case 2:
               Change_of_speech change_of_speechFragment = new Change_of_speech();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,change_of_speechFragment);
                fragmentTransaction.commit();
                break;
            case 3:
                Change_of_voice change_of_voiceFragment = new Change_of_voice();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,change_of_voiceFragment);
                fragmentTransaction.commit();
                break;
            case 4:
                Correct_Spellings correct_spellingsFragment = new Correct_Spellings();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,correct_spellingsFragment);
                fragmentTransaction.commit();
                break;
            case 5:
               One_Word_Substitutes one_word_substitutesFragment = new One_Word_Substitutes();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,one_word_substitutesFragment);
                fragmentTransaction.commit();
                break;
            case 6:
                Related_Pair_Words related_pair_wordsFragment = new Related_Pair_Words();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,related_pair_wordsFragment);
                fragmentTransaction.commit();
                break;
            case 7:
                Sentence_Correction sentence_correctionFragment = new Sentence_Correction();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,sentence_correctionFragment);
                fragmentTransaction.commit();
                break;
            case 8:
                Selecting_Words selecting_wordsFragment = new Selecting_Words();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,selecting_wordsFragment);
                fragmentTransaction.commit();
                break;
            case 9:
                Sentence_Improvement sentence_improvementFragment = new Sentence_Improvement();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,sentence_improvementFragment);
                fragmentTransaction.commit();
                break;
            case 10:
                Spotting_Errors spotting_errorsFragment = new Spotting_Errors();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder,spotting_errorsFragment);
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
