package hitesh.asimplegame;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuestionDBOpenHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 10;

    private static final String DATABASE_NAME = "mathsone";

    private static final String TABLE_EASY = "easy";
    private static final String TABLE_MEDIUM = "medium";
    private static final String TABLE_HARD = "hard";

    private static final String KEY_ID = "qid";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; // correct option
    private static final String KEY_OPTA = "opta"; // option a
    private static final String KEY_OPTB = "optb"; // option b
    private static final String KEY_OPTC = "optc"; // option c

    private static final int entireNumberOfQuestions = 21;

    QuestionRandom[] numberOfQuestions = new QuestionRandom[entireNumberOfQuestions];

    private SQLiteDatabase database;

    public QuestionDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database = db;
        String sql1 = "CREATE TABLE IF NOT EXISTS " + TABLE_EASY + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql1);

        String sql2 = "CREATE TABLE IF NOT EXISTS " + TABLE_MEDIUM + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql2);

        String sql3 = "CREATE TABLE IF NOT EXISTS " + TABLE_HARD + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";

        db.execSQL(sql3);

        addEasyQuestion();
        addMediumQuestion();
        addHardQuestion();

    }

    void addEasyQuestion() {

        for (int i = 0; i < entireNumberOfQuestions; i++) {
            numberOfQuestions[i] = new QuestionRandom(1);
            addEasyQuestion(numberOfQuestions[i]);
        }
    }

    void addMediumQuestion() {

        for (int i = 0; i < entireNumberOfQuestions; i++) {
            numberOfQuestions[i] = new QuestionRandom(2);
            addMediumQuestion(numberOfQuestions[i]);
        }
    }

    void addHardQuestion() {

        for (int i = 0; i < entireNumberOfQuestions; i++) {
            numberOfQuestions[i] = new QuestionRandom(3);
            addHardQuestion(numberOfQuestions[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIUM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARD);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int newV, int OldV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EASY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDIUM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HARD);
        onCreate(db);
    }

    public static void setRandomDB() {
        if (DATABASE_VERSION <= 9) {
            DATABASE_VERSION = 10;
        } else {
            DATABASE_VERSION = 9;
        }
    }

    // Adding new question
    public void addEasyQuestion(Question easy) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, easy.getQUESTION());
        values.put(KEY_ANSWER, easy.getANSWER());
        values.put(KEY_OPTA, easy.getOPTA());
        values.put(KEY_OPTB, easy.getOPTB());
        values.put(KEY_OPTC, easy.getOPTC());

        // Inserting Row
        database.insert(TABLE_EASY, null, values);
    }

    // Adding new question
    public void addMediumQuestion(Question medium) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, medium.getQUESTION());
        values.put(KEY_ANSWER, medium.getANSWER());
        values.put(KEY_OPTA, medium.getOPTA());
        values.put(KEY_OPTB, medium.getOPTB());
        values.put(KEY_OPTC, medium.getOPTC());

        // Inserting Row
        database.insert(TABLE_MEDIUM, null, values);
    }

    public void addHardQuestion(Question hard) {
        // SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, hard.getQUESTION());
        values.put(KEY_ANSWER, hard.getANSWER());
        values.put(KEY_OPTA, hard.getOPTA());
        values.put(KEY_OPTB, hard.getOPTB());
        values.put(KEY_OPTC, hard.getOPTC());

        // Inserting Row
        database.insert(TABLE_HARD, null, values);
    }


    public List<Question> getAllEasyQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EASY;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllMediumQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MEDIUM;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

    public List<Question> getAllHardQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_HARD;
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
}
