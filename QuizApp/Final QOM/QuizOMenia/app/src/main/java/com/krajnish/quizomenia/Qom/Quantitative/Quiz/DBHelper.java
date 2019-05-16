package com.krajnish.quizomenia.Qom.Quantitative.Quiz;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RACE on 10/25/2015.
 */

public class DBHelper extends SQLiteOpenHelper {

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
    public DBHelper(Context context) {
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
                "CREATE TABLE QuantitativeQuizHCFLCM (_id INTEGER PRIMARY KEY, question TEXT, answer TEXT, incorrect1 TEXT, incorrect2 TEXT, incorrect3 TEXT, difficulty INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + "QuantitativeQuizHCFLCM");
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
        Cursor c = myDataBase.rawQuery("SELECT * FROM QuantitativeQuizHCFLCM WHERE DIFFICULTY=" + difficulty +
                " ORDER BY RANDOM() LIMIT " + numQ, null);
        while (c.moveToNext()) {
            Question q = new Question();
            q.setQuestion(c.getString(1));
            q.setAnswer(c.getString(2));
            q.setOption1(c.getString(3));
            q.setOption2(c.getString(4));
            q.setOption3(c.getString(5));
            q.setRating(difficulty);
            questionSet.add(q);
        }
        return questionSet;
    }
}