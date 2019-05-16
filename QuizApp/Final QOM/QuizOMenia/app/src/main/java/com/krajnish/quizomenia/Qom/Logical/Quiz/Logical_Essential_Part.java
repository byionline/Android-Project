package com.krajnish.quizomenia.Qom.Logical.Quiz;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.krajnish.quizomenia.Qom.Quantitative.Quiz.DBHelper;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.QOMRules;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.Question;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.QuestionActivity;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.Quiz;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.RajnishAplication;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.Select;
import com.krajnish.quizomenia.Qom.Quantitative.Quiz.Setting;
import com.krajnish.quizomenia.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class Logical_Essential_Part extends Fragment  implements View.OnClickListener {

    public Logical_Essential_Part(){
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.activity_quantitative__hcf__lcm, container, false);
        view = inflater.inflate(R.layout.activity_quiz_start_page, container, false);
        final TextView textViewToChange = (TextView) view.findViewById(R.id.quizstartpage);
        textViewToChange.setText(
                "Logical Essential");
        Button starttest = (Button) view.findViewById(R.id.btnStart);
        starttest.setOnClickListener(this);
        Button setting = (Button) view.findViewById(R.id.btnSetting);
        setting.setOnClickListener(this);
        Button rules = (Button) view.findViewById(R.id.btnRules);
        rules.setOnClickListener(this);

        Button exit = (Button) view.findViewById(R.id.btnExit);
        exit.setOnClickListener(this);

        return view;


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * Listener for menu
     * @param v
     */
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.btnStart:
                List<Question> questions = getQuestionSetFromDb();
                //retrive Question set

                Quiz q = new Quiz();
                q.setQuestions(questions);
                q.setNumRounds(getNumQuestions());
                ((RajnishAplication) getActivity().getApplication()).setStartQuiz(q);

                //Start Quiz Now

                i = new Intent( getActivity(),QuestionActivity.class);
                startActivityForResult(i, Select.STARTTEST);

                break;
            /**
             *   Intent intent = new Intent(getActivity(),Activity .class);
             startActivity(intent);
             Used in fragment for starting an activity
             */


            case R.id.btnSetting:
                i = new Intent(getActivity(), Setting.class);
                startActivityForResult(i, Select.SETTING);
                break;
            case R.id.btnRules:
                i = new Intent(getActivity(), QOMRules.class);
                startActivityForResult(i, Select.RULES);
                break;
            case R.id.btnExit:
                getActivity().finish();
                break;

        }

    }



    private List<Question> getQuestionSetFromDb() throws Error{
        int level = getLevelSetting();
        int numQuestions = getNumQuestions();
        DBHelperpipes myDbhelper = new DBHelperpipes(getActivity().getApplicationContext());

        myDbhelper.createDataBase();
        try {
            myDbhelper.openDataBase();

        }catch (SQLException sqle){
            // throw sqle;
            System.out.println("Database could not created.");

        }
        try {
            myDbhelper.openDataBase();
        }catch (SQLException e){
            //throw  e;
            System.out.println("Database could not open.");
        }
        List<Question> questions = myDbhelper.getQuestionSet(level, numQuestions);
        myDbhelper.close();

        return questions;
    }
    /**
     * Method to return the difficulty settings
     */
    private int getLevelSetting() {

        /**
         * // this = your fragment
         SharedPreferences preferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

         */
        SharedPreferences settings = this.getActivity().getSharedPreferences(Select.UPDATE,0);
        int choose = settings.getInt(Select.LEVEL, Select.LEVEL0);
        return choose;
    }

    /**
     * Method to return the number of questions for the quiz
     */
    private int getNumQuestions() {


        /**
         * // this = your fragment
         SharedPreferences preferences = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);

         */
        SharedPreferences settings = this.getActivity().getSharedPreferences(Select.UPDATE,0);
        int numRounds = settings.getInt(Select.NUM_ROUNDS, 5);
        return numRounds;
    }

    private static class DBHelperpipes extends SQLiteOpenHelper {

        //The Android's default system path of  application database.
        private static String DB_PATH = "/data/data/com.krajnish.quizomenia/databases/";
        private static String DB_NAME = "questionsDb.sqlite";
        private final Context myContext;
        private SQLiteDatabase myDataBase;


        /**
         * Constructor
         * To access to the application assets and resources.
         * @param context
         */
        public DBHelperpipes(Context context) {
            super(context, DB_NAME, null, 1);
            this.myContext = context;
        }



        /**
         * Creates a empty database on the system and rewrites it with database .
         */
        public void createDataBase() {

            boolean dbExist;
            try {

                dbExist = checkDataBase();


            } catch (SQLiteException e) {

                e.printStackTrace();
                throw new Error("database dose not exist");

            }

            if (dbExist) {
                //do nothing - database already exist
            } else {
                //Create and/or open a database.
                this.getReadableDatabase();

                try {

                    copyDataBase();


                } catch (IOException e) {

                    e.printStackTrace();
                    throw new Error("Error copying database");

                }


            }

        }


        /**
         * Copy database from local assets-folder to the just created empty database in the
         * system folder, from where it can be accessed and handled.
         * This is done by transfering bytestream.
         */
        private void copyDataBase() throws IOException {

            //Open local db as the input stream
            InputStream myInput = myContext.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH + DB_NAME;

            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, length);
            }
            Log.v("log", "copy finish");
            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }

        /**
         * Check if the database already exist to avoid re-copying the file each time we  open the application.
         *
         * @return true if it exists, false if it doesn't
         */
 /*   private boolean checkDataBase(){
        SQLiteDatabase checkDB = null;
        try{
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        }catch(SQLiteException e){
            //database does't exist yet.
        }
        if(checkDB != null){
            checkDB.close();
        }

        return checkDB != null ? true : false;
    }*/
        private boolean checkDataBase() {
            boolean checkdb = false;
            try {
                String myPath = myContext.getFilesDir().getAbsolutePath().replace("files", "databases") + File.separator + DB_NAME;
                File dbfile = new File(myPath);
                checkdb = dbfile.exists();
            } catch (SQLiteException e) {
                System.out.println("Database doesn't exist");
            }

            return checkdb;
        }

        public SQLiteDatabase openDataBase() throws SQLException {
            //Open the database
            String myPath = DB_PATH + DB_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
            return myDataBase;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE \"EssentialPart\" (\"Questions\" TEXT, \"Answer\" TEXT, \"Incorrect1\" TEXT, \"Incorrect2\" TEXT, \"Incorrect3\" TEXT, \"difficulty\" INTEGER)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(DBHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to "
                            + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + "EssentialPart");
            onCreate(db);

        }

        @Override
        public synchronized void close() {
            if (myDataBase != null)
                myDataBase.close();
            super.close();
        }


        // A public helper methods to access and get content from the database.
        // myDataBase.query(....) is used to query a cursor
        // create adapters for views.


        public List<Question> getQuestionSet(int difficulty, int numQ) {
            List<Question> questionSet = new ArrayList<Question>();
            Cursor c = myDataBase.rawQuery("SELECT * FROM EssentialPart WHERE DIFFICULTY=" + difficulty +
                    " ORDER BY RANDOM() LIMIT " + numQ, null);
            while (c.moveToNext()) {
                Question q = new Question();
                q.setQuestion(c.getString(0));
                q.setAnswer(c.getString(1));
                q.setOption1(c.getString(2));
                q.setOption2(c.getString(3));
                q.setOption3(c.getString(4));
                q.setRating(difficulty);
                questionSet.add(q);
            }
            return questionSet;
        }
    }
}

